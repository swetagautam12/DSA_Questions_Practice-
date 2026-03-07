class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String t = s + s;   

        int ans = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;

        for(int i = 0; i < t.length(); i++) {

            
            if(t.charAt(i) != ((i % 2 == 1) ? '1' : '0')) diff1++;
            if(t.charAt(i) != ((i % 2 == 1) ? '0' : '1')) diff2++;

         
            if(i >= n) {
                if(t.charAt(i-n) != (((i-n) % 2 == 1) ? '1' : '0')) diff1--;
                if(t.charAt(i-n) != (((i-n) % 2 == 1) ? '0' : '1')) diff2--;
            }

          
            if(i >= n-1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}