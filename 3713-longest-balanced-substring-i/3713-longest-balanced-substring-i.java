class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        for(int i=0; i<n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=i; j<n; j++) {
                char cur = s.charAt(j);
                map.put(cur, map.getOrDefault(s.charAt(j),0)+1);
                HashSet<Integer> set = new HashSet<>(map.values());
                if(set.size()==1) {
                    int cl = j-i+1;
                    max = Math.max(cl, max);
                }
            }
        }
        return max;
    }
}