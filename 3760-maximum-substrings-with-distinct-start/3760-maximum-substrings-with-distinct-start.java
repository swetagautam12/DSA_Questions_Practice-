class Solution {
    public int maxDistinct(String s) {
        boolean[] hash = new boolean[256];
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (!hash[ch]) {
                hash[ch] = true;
                count++;
            }
        }
        return count;
    }
}