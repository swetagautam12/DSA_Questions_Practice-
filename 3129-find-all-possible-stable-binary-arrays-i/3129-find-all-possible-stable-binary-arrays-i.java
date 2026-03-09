class Solution {
    static int mod = 100_00_00_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
       int [][][] dp = new int[2][zero+1][one+1];
       
       dp[0][0][0] = dp[1][0][0] = 1;
       int data[] = new int[one+1];

       for(int i=0;i<=zero;i++){
            int columnPrefix = 0;
            for(int j=0;j<=one;j++){
                if(i-limit-1>=0){
                    data[j] =(data[j]-dp[1][i-limit-1][j])%mod;
                    data[j] = (data[j]+mod)%mod;
                }
                dp[0][i][j] = (dp[0][i][j]+data[j])%mod;
                if(j-limit-1>=0){
                    columnPrefix =(columnPrefix-dp[0][i][j-limit-1])%mod;
                    columnPrefix = (columnPrefix+mod)%mod;
                } 
                dp[1][i][j] = (dp[1][i][j]+columnPrefix)%mod;

                columnPrefix = (columnPrefix+dp[0][i][j])%mod;
                data[j] =(data[j]+dp[1][i][j])%mod;
            }
       }
       return (dp[1][zero][one]+dp[0][zero][one])%mod; 
    }
}