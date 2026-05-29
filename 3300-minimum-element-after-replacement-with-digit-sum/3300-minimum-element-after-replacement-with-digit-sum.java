class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {
            int sumDigit = 0;

            while (num > 0) {
                sumDigit += num % 10;
                num /= 10;
            }

            ans = Math.min(ans, sumDigit);
        }

        return ans;
    }
}