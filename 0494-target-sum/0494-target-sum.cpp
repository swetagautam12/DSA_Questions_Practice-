class Solution {
    int countSubsets(vector<int> arr, int n, int sum){
        int zeroCount = 0;
        for(int x : arr) if(x == 0) zeroCount++;

        vector<vector<int>> dp(n+1, vector<int>(sum+1, 0));
        for(int i=0; i<=n; i++) dp[i][0] = 1;

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=sum; j++){
                if(arr[i-1] <= j && arr[i-1] != 0)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum] * (1 << zeroCount);
    }
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);

        if (abs(target) > sum) return 0;
        if ((sum + target) % 2) return 0;

        int reqSum = (sum + target) / 2;
        return countSubsets(nums, n, reqSum);
    }
};