class Solution {
    public String removeStars(String s) {


        StringBuilder s2 = new StringBuilder();
        for(int i =0 ;i<s.length();i++){
            if(s.charAt(i) =='*'){
                s2.deleteCharAt(s2.length() -1);
            }else {
                s2.append(s.charAt(i));
            }
        }

        return s2.toString();
        
    }
}