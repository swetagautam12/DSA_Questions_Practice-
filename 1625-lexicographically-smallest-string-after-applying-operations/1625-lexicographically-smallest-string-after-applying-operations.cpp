class Solution {
public:
    string add_str(string s, int a) {
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                int num = s[i] - '0';
                s[i] = (num + a) % 10 + '0';
            }
        }
        return s;
    }

    string rotate_str(string s, int b) {
        int n = s.size();
        b %= n;
        return s.substr(n - b) + s.substr(0, n - b);
    }

    string findLexSmallestString(string s, int a, int b) {
        set<string> visited;
        queue<string> q;
        q.push(s);
        visited.insert(s);

        while (!q.empty()) {
            string cur = q.front();
            q.pop();

            string added = add_str(cur, a);
            string rotated = rotate_str(cur, b);

            if (!visited.count(added)) {
                visited.insert(added);
                q.push(added);
            }
            if (!visited.count(rotated)) {
                visited.insert(rotated);
                q.push(rotated);
            }
        }

        return *min_element(visited.begin(), visited.end());
    }
};