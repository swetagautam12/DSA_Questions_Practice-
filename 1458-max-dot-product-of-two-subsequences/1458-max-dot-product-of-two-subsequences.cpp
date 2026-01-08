class Solution {
public:
    int maxDotProduct(vector<int>& A, vector<int>& B) {
        int n = A.size(), m = B.size();
        vector<vector<int>> dp(n, vector<int>(m));

        for (int j = 0; j < m; ++j) {
            dp[0][j] = A[0] * B[j];
            if (j) dp[0][j] = max(dp[0][j], dp[0][j-1]);
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = A[i] * B[j];
                if (j) dp[i][j] += max(dp[i-1][j-1], 0);
                dp[i][j] = max(dp[i][j], dp[i-1][j]);
                if (j) dp[i][j] = max(dp[i][j], dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
};