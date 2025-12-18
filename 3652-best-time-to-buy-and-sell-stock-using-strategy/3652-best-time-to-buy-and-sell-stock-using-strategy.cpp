class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        int n = prices.size();
        int k2 = k / 2;
        
        vector<long long> profit(n);
        for (int i = 0; i < n; i++) {
            profit[i] = strategy[i] * prices[i];
        }

        vector<long long> prefixP(n + 1, 0), prefixA(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefixP[i + 1] = prefixP[i] + prices[i];
            prefixA[i + 1] = prefixA[i] + profit[i];
        }

        long long og_profit = prefixA[n];
        long long max_delta = 0;
        
        for (int l = 0; l <= n - k; l++) {
            long long delta = (prefixP[l + k] - prefixP[l + k2]) - (prefixA[l + k] - prefixA[l]);
            max_delta = max(max_delta, delta);
        }

        return og_profit + max_delta;
    }
};