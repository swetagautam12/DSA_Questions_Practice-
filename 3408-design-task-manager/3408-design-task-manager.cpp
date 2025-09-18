#include <bits/stdc++.h>
using namespace std;

struct Manager {
    int userId;
    int taskId;
    int priority;
};

struct Compare {
    bool operator()(const Manager& a, const Manager& b) const {
        if (a.priority == b.priority)
            return a.taskId < b.taskId; // higher taskId wins
        return a.priority < b.priority; // higher priority wins
    }
};

class TaskManager {
private:
    priority_queue<Manager, vector<Manager>, Compare> pq;
    unordered_map<int, Manager> record; // taskId -> Manager

public:
    TaskManager(vector<vector<int>> tasks) {
        for (auto& t : tasks) {
            Manager m{t[0], t[1], t[2]};
            pq.push(m);
            record[t[1]] = m;
        }
    }

    void add(int userId, int taskId, int priority) {
        Manager m{userId, taskId, priority};
        pq.push(m);
        record[taskId] = m;
    }

    void edit(int taskId, int newPriority) {
        if (record.find(taskId) == record.end()) return;
        Manager old = record[taskId];
        Manager updated{old.userId, taskId, newPriority};
        pq.push(updated);
        record[taskId] = updated;
    }

    void rmv(int taskId) {
        record.erase(taskId); // lazy delete
    }

    int execTop() {
        while (!pq.empty()) {
            Manager top = pq.top();
            pq.pop();

            auto it = record.find(top.taskId);
            if (it == record.end()) continue; // removed
            if (it->second.priority != top.priority) continue; // outdated

            record.erase(it);
            return top.userId; // execute
        }
        return -1;
    }
};