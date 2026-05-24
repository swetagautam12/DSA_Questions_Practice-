class Solution {
    public boolean isValid(String t) {
        Map<Character,Character>m= new HashMap<>();
        m.put(')','(');
        m.put('}','{');
        m.put(']','[');
        Stack<Character > s= new Stack<>();
        for(char c: t.toCharArray()){
            if(m.containsValue(c)){
                s.push(c);

            }
            else if(m.containsKey(c)){
                if(s.isEmpty() || m.get(c) !=s.pop()){
                    return false ;

                }
            }
        }
        return s.isEmpty();
        
    }
}