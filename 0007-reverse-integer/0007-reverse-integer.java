class Solution {
    public int reverse(int x) {
        long final_Num = 0;
        while(x!=0){
            int last__Dig = x%10;
            final_Num += last__Dig;
            final_Num = final_Num*10;
            x= x/10;
        }
        final_Num = final_Num/10;
        if(final_Num > Integer.MAX_VALUE || final_Num<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*final_Num);
        }
        return (int)final_Num;
    }
}