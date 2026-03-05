class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) 
            return false;

        Map<Character, Integer> hm1 = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();

        for (Character c : s.toCharArray()) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }

        if(hm1.equals(hm2))
        {
            return true;
        }
        return false;

    }
}