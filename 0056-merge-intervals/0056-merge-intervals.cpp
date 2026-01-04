class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>>result;
        int size=0;
        result.push_back(intervals[0]);
        for(int i=1;i<intervals.size();i++){
            if(intervals[i][0]<=result[size][1]){
                result[size][1]=max(result[size][1],intervals[i][1]);
            }
            else{
                result.push_back(intervals[i]);
                size++;
            }
        }
        return result;
    }
};