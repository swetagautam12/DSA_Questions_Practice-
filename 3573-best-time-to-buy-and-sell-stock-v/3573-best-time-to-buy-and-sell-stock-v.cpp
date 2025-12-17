class Solution {

    long long dp[1002][600][3][3];

    long long dfs(int idx, vector<int> &prices, int k, int hold, int transactionType) {

        int n = prices.size();
        long long mx = 0;
        long long shortSell = 0;
        long long normalSell = 0;
        long long ntake = 0;

        if(idx == n) return 0;

        if(k == 0) return 0;

        if(idx == n - 1) {

            if(hold == 1) {

                if(transactionType == 1) {
                    return -(1LL * prices[idx]);
                } 

                return (1LL * prices[idx]) ;

            }

            return 0;
        }

        if(dp[idx][k][hold][transactionType + 1] != -1) {
            return dp[idx][k][hold][transactionType + 1];
        }

        ntake = dfs(idx + 1, prices, k, hold, transactionType);

        if(hold == 0) {

            shortSell = prices[idx] + dfs(idx + 1,  prices, k, 1, 1);
            normalSell = -prices[idx] + dfs(idx + 1, prices, k, 1, 0);

            return dp[idx][k][hold][transactionType + 1] = max({shortSell, normalSell, ntake});
        } 

        if(transactionType == 1) {
            shortSell = -prices[idx] + dfs(idx + 1,  prices, k - 1, 0, -1);
            return dp[idx][k][hold][transactionType + 1] = max(shortSell, ntake);
        } 

        normalSell = prices[idx] + dfs(idx + 1, prices, k - 1, 0, -1);
        
        return dp[idx][k][hold][transactionType + 1] = max(normalSell, ntake);

        
    }
public:
    long long maximumProfit(vector<int>& prices, int k) {
        long long ans = 0;
        int n = prices.size();

        for(int i = 0; i < n; i++) {
            for(int a = 0; a <= k; a++) {
                for(int b = 0; b < 3; b++) {
                    for(int c = 0; c < 3; c++) {
                        dp[i][a][b][c] = -1;
                    }
                }
            }
        }
        return dfs(0, prices, k, 0, -1);
    }
};