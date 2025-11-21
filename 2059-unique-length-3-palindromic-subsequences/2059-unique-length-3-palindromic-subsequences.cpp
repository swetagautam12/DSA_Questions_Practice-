class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        vector<vector<int>> firstLastIdxes(26, vector<int>(2, -1));
        
        for(int i=0; i<n; i++){
            char c = s[i];
            if(firstLastIdxes[c-'a'][0] == -1){
                firstLastIdxes[c-'a'][0] = i;
            }
            firstLastIdxes[c-'a'][1] = i;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            int left = firstLastIdxes[i][0];
            int right = firstLastIdxes[i][1];
            unordered_set<char> charsInBetween;
            for(int j=left+1; j<right; j++){
                charsInBetween.insert(s[j]);
            }
            count += charsInBetween.size();
        }
        return count;
    }
};
