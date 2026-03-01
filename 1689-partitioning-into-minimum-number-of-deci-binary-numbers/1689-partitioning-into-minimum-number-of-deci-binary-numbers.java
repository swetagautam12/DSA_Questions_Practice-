class Solution {
    public int minPartitions(String n) {
        int out = 0;

        for(char c: n.toCharArray()){
            out = Math.max(out, c - '0');

            if(out == 9) return 9;
        }
        return out;
    }
}