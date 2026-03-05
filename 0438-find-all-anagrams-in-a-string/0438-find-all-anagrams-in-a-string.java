class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> num = new ArrayList<>();
        int freq1[] =new int[26];
        int freq2[] =new int[26];
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            int index=c-'a';
            freq1[index]++;
        }
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            int index=ch-'a';
            freq2[index]++;

            if(right-left+1>p.length()){
                freq2[s.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(freq1,freq2)){
                num.add(left);
            }
        }
        return num;
    }
}
    