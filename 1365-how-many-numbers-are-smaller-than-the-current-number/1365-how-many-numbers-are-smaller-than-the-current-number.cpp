class Solution {
public:
    static vector<int> smallerNumbersThanCurrent(const vector<int>& a) {
        const int n = a.size();
        const int m = 101;
        unsigned short b[m] = {0};
        for (int i = 0; i < n; ++b[a[i++]]);
        for (int i = 1; i < m; ++i) b[i] += b[i - 1];
        vector<int> c(n);
        for (int i = 0; i < n; ++i) c[i] = a[i] ? b[a[i] - 1] : 0;
        return c;
    }
};