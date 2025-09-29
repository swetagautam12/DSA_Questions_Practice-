class Solution {
public:
    int dp[31][31][31][31], freq[26];
    string str1, str2;
    bool solve(int i, int j, int ii, int jj) {
        if (i > j || ii > jj)
            return false;
        if (dp[i][j][ii][jj] != -1)
            return dp[i][j][ii][jj];
        memset(freq, 0, sizeof(freq));
        for (int k = i; k <= j; k++)
            freq[str1[k] - 'a']++;
        for (int k = ii; k <= jj; k++)
            freq[str2[k] - 'a']--;
        for (int k : freq) {
            if (k != 0) {
                dp[i][j][ii][jj] = false;
                return false;
            }
        }
        if (j - i < 3) {
            dp[i][j][ii][jj] = true;
            return true;
        }
        for (int k = 0; k < j - i; k++) {
            if (solve(i, i + k, ii, ii + k) &&
                solve(i + k + 1, j, ii + k + 1, jj)) {
                dp[i][j][ii][jj] = true;
                return true;
            }
            if (solve(i, i + k, jj - k, jj) &&
                solve(i + k + 1, j, ii, jj - k - 1)) {
                dp[i][j][ii][jj] = true;
                return true;
            }
        }
        dp[i][j][ii][jj] = false;
        return false;
    }
    bool isScramble(string s1, string s2) {
        str1 = s1;
        str2 = s2;
        memset(dp, -1, sizeof(dp));
        return solve(0, s1.length() - 1, 0, s2.length() - 1);
    }
};