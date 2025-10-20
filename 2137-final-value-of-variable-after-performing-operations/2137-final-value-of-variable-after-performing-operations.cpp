class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int cnt = 0;
        for(string s: operations){
            if(s[1] == '-') cnt--;
            else cnt++;
        }
        return cnt;
    }
};