class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& q) {
        vector<vector<int>> a(n+1, vector<int>(n+1, 0));

        for (auto &v : q) {
            int r1=v[0], c1=v[1], r2=v[2], c2=v[3];
            a[r1][c1]++;
            if (c2+1 < n) a[r1][c2+1]--;
            if (r2+1 < n) a[r2+1][c1]--;
            if (r2+1 < n && c2+1 < n) a[r2+1][c2+1]++;
        }

        for (int i=0;i<n;i++)
            for (int j=1;j<n;j++)
                a[i][j] += a[i][j-1];

        for (int j=0;j<n;j++)
            for (int i=1;i<n;i++)
                a[i][j] += a[i-1][j];

        a.resize(n);
        for (auto &row : a) row.resize(n);

        return a;
    }
};