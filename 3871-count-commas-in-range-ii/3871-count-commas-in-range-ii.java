class Solution {
    public long countCommas(long n) {
        if (n < 1000) {
            return 0;
        }

        long power = 1000;
        int groups = 1;

        while (power <= n / 1000) {
            power *= 1000;
            groups++;
        }

        long result = groups * (n - power + 1);
        long currentPower = 1000;

        for (int i = 1; i < groups; i++) {
            result += 999 * currentPower * i;
            currentPower *= 1000;
        }

        return result;
    }
}