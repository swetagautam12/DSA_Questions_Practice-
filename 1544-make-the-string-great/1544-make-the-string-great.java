class Solution {
    public boolean ispossible(char ch1 , char ch2){
        if(ch1 == ch2) return false;
        ch1 = Character.toLowerCase(ch1);
        ch2 = Character.toLowerCase(ch2);

        if(ch1 == ch2) return true;
        return false ;
    }
    public String makeGood(String s) {
        int n =s.length();
        String result ="";
        for(int i =0; i<n;i++){
            char ch = s.charAt(i);
            int len = result.length();
            if(len > 0 && ispossible(ch,(result.charAt(len-1)))){
                result =result.substring(0,len-1);

            }else result = result.concat(String.valueOf(ch));
        }
        return result ;
    }
}