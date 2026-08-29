class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String k=new String(c);
            if(!ans.containsKey(k)) ans.put(k,new ArrayList<>());
            ans.get(k).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
