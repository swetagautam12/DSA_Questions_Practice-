class Solution {
public:
    long long solve(int i, vector<pair<int, int>> &tmp, vector<long long> &dp) {
        if(i == tmp.size()) return 0;

        if(dp[i] != -1) return dp[i];

        long long op1 = solve(i + 1, tmp, dp);
        long long op2 = (tmp[i].first * 1LL * tmp[i].second);

        int j = i;
        while(j < tmp.size() && tmp[j].first <= tmp[i].first + 2) {
            j++;
        }
        op2 += solve(j, tmp, dp);

        return dp[i] = max(op1, op2);
    }

    long long maximumTotalDamage(vector<int>& power) {
        unordered_map<int, int> mp;
        for(auto el: power) mp[el]++;

        vector<pair<int, int>> tmp;
        for(auto el: mp) {
            tmp.push_back({el.first, el.second});
        }

        vector<long long> dp(power.size(), -1);

        sort(tmp.begin(), tmp.end());
        return solve(0, tmp, dp);
    }
};