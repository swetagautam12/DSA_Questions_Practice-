class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = 1 << k;
        if (s.length() < n)
            return false;

        boolean[] used = new boolean[n];
        int windowStr = 0;

        if (k > 1) {
            windowStr = Integer.parseInt(s.substring(0, k - 1), 2);
        }

        for (int i = k - 1; i < s.length(); i++) {
            windowStr = (windowStr << 1) + (s.charAt(i) - '0');
            windowStr &= (n - 1);
            used[windowStr] = true;
        }

        for (boolean u : used) {
            if (!u)
                return false;
        }

        return true;
    }
}