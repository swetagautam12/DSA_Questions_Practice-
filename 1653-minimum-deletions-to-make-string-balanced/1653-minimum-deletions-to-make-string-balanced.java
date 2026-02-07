class Solution {
    public int minimumDeletions(String s) {
        int bc = 0;
        int ac = 0;
        int c = 0;
        for(char ch: s.toCharArray()){
            if(ch == 'b'){
                bc++;
            }else{
                boolean flag = false;
                ac++;
                while(bc > 0 && ac > 0){
                    flag = true;
                    c++;
                    bc--;
                    ac--;
                }
                if(!flag){
                    ac = 0;
                }
            }
        }
        return c;
    }
}