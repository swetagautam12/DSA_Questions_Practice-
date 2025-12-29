class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        map<std::string, vector<char>> Mimap;
        for(string s : allowed)
        {
            Mimap[s.substr(0, 2)].push_back(s[2]);
        }

        vector<vector<char>> pyramid(bottom.size());
        for(char c : bottom) pyramid[bottom.size()-1].push_back(c);
        
        function<bool(int, int)> backtrack = [&](int level, int idx)
        {
            if(level < 0) return true;
            if(idx > level)
            {
                return backtrack(level-1, 0);
            }
            string base = {pyramid[level+1][idx], pyramid[level+1][idx+1]};
            bool valid = false;
            for(char top : Mimap[base])
            {
                pyramid[level].push_back(top);
                valid = backtrack(level, idx+1);
                if(valid) break;
                pyramid[level].pop_back();
            }
            return valid;
        };

        return backtrack(bottom.size()-2,0);
    }
};