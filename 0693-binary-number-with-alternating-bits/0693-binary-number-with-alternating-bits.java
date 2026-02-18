class Solution {
    public boolean hasAlternatingBits(int n) {
        int bitpos = 0;
        int setMsbPos = 0;

        while (bitpos < 32) {
            if (((n >> bitpos) & 1) == 1) {
                setMsbPos = bitpos;
            }
            bitpos++;
        }

        bitpos = 1;
        int lastBit = n & 1;

        while (bitpos <= setMsbPos) {
            if (lastBit != ((n >> bitpos) & 1)) {
                lastBit = (lastBit == 1) ? 0 : 1;
            } else {
                return false;
            }
            bitpos++;
        }
        return true;
    }
}