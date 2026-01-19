class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
            }
        }

        int left = 1, right = Math.min(m, n), res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean isValid = false;

            for (int i = mid; i <= m && !isValid; i++) {
                for (int j = mid; j <= n; j++) {
                    int square_sum = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid];
                    if (square_sum <= threshold) {
                        isValid = true;
                        break;
                    }
                }
            }

            if (isValid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}