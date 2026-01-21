class Solution {
    public int minLengthAfterRemovals(String s) {
        int aCount = 0;
        int bCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                aCount++;
            } else if (ch == 'b') {
                bCount++;
            }
        }

        
        return Math.abs(aCount - bCount);
    }
}