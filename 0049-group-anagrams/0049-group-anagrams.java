class Solution {
    public List<List<String>> groupAnagrams(String[] s) {

        HashMap<String,List<String>> map = new HashMap<>();
        for(int i =0;i<s.length;i++){
            char a[] = s[i].toCharArray();
            Arrays.sort(a);
            String sort= new String(a);
            if(!map.containsKey(sort))map.put(sort, new ArrayList<>());
            map.get(sort).add(s[i]);


        }
        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));

        }
        return ans ; 
        
    }
}