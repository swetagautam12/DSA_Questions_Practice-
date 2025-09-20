class Solution {
    int memoization(int i, vector<int>& coins, int t, vector<vector<int>>& dp) {
        if (i==0) {
            if (t%coins[0]==0) return t/coins[0];
            return 1e9;
        }
        if (dp[i][t]!=-1) return dp[i][t];
        int not_take=memoization(i-1, coins, t, dp);
        int take=1e9;
        if (t>=coins[i]) take=1+memoization(i, coins, t-coins[i], dp);
        return dp[i][t]=min(not_take, take);
    }

public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int>(amount+1,-1));
        int res=memoization(n-1, coins, amount, dp);
        return (res>=1e9) ? -1 : res;
    }
};