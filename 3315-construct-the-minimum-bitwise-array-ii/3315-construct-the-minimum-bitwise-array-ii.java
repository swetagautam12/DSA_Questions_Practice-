class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int v = nums.get(i);
            result[i] = (v == 2) ? -1 : calc(v);
        }
        return result;
    }

    private static int calc(int value) {
        int bitsOnRight = 0;
        int v = value;
        while ((v & 1) != 0) {
            bitsOnRight++;
            v >>>= 1;
        }
        if (bitsOnRight == 1) return value - 1;
        int woBitsOnRight = value ^ ((1 << bitsOnRight) - 1);
        return woBitsOnRight | ((1 << (bitsOnRight - 1)) - 1);
    }
}