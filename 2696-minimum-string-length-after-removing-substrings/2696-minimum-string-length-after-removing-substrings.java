class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(!st.isEmpty() && (st.peek() == 'A' && ch == 'B')){
                st.pop();
            }else if(!st.isEmpty() && (st.peek() == 'C' && ch == 'D')){
                st.pop();
            }else{
                st.push(ch);  
            }
        }
        return st.size();
    }
}