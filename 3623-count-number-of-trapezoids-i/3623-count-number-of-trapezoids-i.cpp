class Solution {
public:
    using ll = long long;
    int mod = 1000000007;
    int countTrapezoids(vector<vector<int>>& points) {
        unordered_map<int, int> yc;
        for (auto& v : points)
            yc[v[1]]++;

        ll nC2Sum = 0, res = 0;
        for (auto& [y, c] : yc) {
            if (c < 1)
                continue;
            nC2Sum += ((ll)c * (c - 1)) / 2;
        }
        for (auto& [y, c] : yc) {
            if (c < 2)
                continue;
            ll curr = ((ll)c * (c - 1)) / 2;
            nC2Sum -= curr;
            res = (((curr % mod) * (nC2Sum % mod)) % mod + res) % mod;
        }
        return res;
    }
};