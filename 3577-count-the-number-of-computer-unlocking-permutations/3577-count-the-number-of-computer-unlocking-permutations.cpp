class Solution {
public:
    const int MOD = 1e9 + 7;
    int countPermutations(vector<int>& complexity) {
        bool isValid = true;
        int n = complexity.size(), first = complexity[0];
        for(int i = 1;i<n;i++){
            if(complexity[i] <= first){
                isValid = false;
                break;
            }
        }
        if(!isValid)
            return 0;
        long long ans = 1;
        for(int i = 2;i<n;i++){
            ans = (ans * i) % MOD;
        }
        return ans;
    }
};