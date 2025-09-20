class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        unordered_map<int,int> mp;
        for(auto row : grid){
            for(int col : row){
                mp[col]++;
            }
        }
        int n = grid.size();
        int repeat;
        int missing;
        for(int i=1; i<=n*n; i++){
            if(mp.find(i)!=mp.end()){
                if(mp[i]!=1) repeat = i;
            }
            else missing = i;
        }
        return {repeat,missing};
    }
};