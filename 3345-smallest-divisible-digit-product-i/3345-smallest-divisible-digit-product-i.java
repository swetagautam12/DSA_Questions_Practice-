class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<100;i++){
            int m=1;
            if(i>=0 && i<10){
                m=i;

            }else if(i>=10 && i<100){
                m=(i/10)*(i%10);

            }
            if(m% t==0){
                return i;
            }
        }
        return 100;
    }
}