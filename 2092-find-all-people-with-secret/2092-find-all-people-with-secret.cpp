class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        vector<vector<pair<int,int>>>g(n);

        for(auto i : meetings){
            g[i[0]].push_back({i[1],i[2]});
            g[i[1]].push_back({i[0],i[2]});
        }
        
        priority_queue<pair<int,int>, vector<pair<int,int>>,greater<pair<int,int>>>pq;
        pq.push({0,0});
        pq.push({0,firstPerson});

        vector<bool>vis(n);

        while(!pq.empty()){
            auto[t,x] = pq.top();
            pq.pop();
            if(vis[x])continue;
            vis[x]=true;

            for(auto it : g[x]){
                if(vis[it.first])continue;
                if(it.second >= t)pq.push({it.second,it.first});
            }
        }

        vector<int>result;
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == true)result.push_back(i);
        }
        return result;
    }
};