class Solution {
    static class Solver {
        int n;
        long[][] memo;
        int[] nums;

        long solve(int i, int trend) {
            if (i == n) {
                return (trend == 3) ? 0 : Long.MIN_VALUE / 2;
            }

            if (memo[i][trend] != Long.MIN_VALUE) {
                return memo[i][trend];
            }

            long take = Long.MIN_VALUE / 2;
            long skip = Long.MIN_VALUE / 2;

        
            if (trend == 0) {
                skip = solve(i + 1, 0);
            }

           
            if (trend == 3) {
                take = nums[i];
            }

            if (i + 1 < n) {
                int curr = nums[i];
                int next = nums[i + 1];

                if (trend == 0 && next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 1));
                } else if (trend == 1) {
                    if (next > curr) {
                        take = Math.max(take, curr + solve(i + 1, 1));
                    } else if (next < curr) {
                        take = Math.max(take, curr + solve(i + 1, 2));
                    }
                } else if (trend == 2) {
                    if (next < curr) {
                        take = Math.max(take, curr + solve(i + 1, 2));
                    } else if (next > curr) {
                        take = Math.max(take, curr + solve(i + 1, 3));
                    }
                } else if (trend == 3 && next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 3));
                }
            }

            return memo[i][trend] = Math.max(take, skip);
        }
    }

    public long maxSumTrionic(int[] nums) {
        Solver s = new Solver();
        s.n = nums.length;
        s.nums = nums;
        s.memo = new long[s.n + 1][4];

        for (int i = 0; i <= s.n; i++) {
            for (int j = 0; j < 4; j++) {
                s.memo[i][j] = Long.MIN_VALUE;
            }
        }

        return s.solve(0, 0);
    }
}