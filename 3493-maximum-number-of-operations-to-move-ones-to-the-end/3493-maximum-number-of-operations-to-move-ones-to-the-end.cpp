class Solution {
public:
    int maxOperations(string s) {
        int res = 0;
        for(int i = 0, ones = 0, n = s.length(); i < n; ++i){
            ones += (s[i] == '1');
            if(i && s[i] < s[i - 1]) res += ones;
        }   
        return res;
    }
};