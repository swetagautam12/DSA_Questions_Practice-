class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long idealSum = n*(n+1)/2;
        long idealSumSquare = (n*(n+1)*(2L*n+1))/6;
        long actualSum = 0;
        long actualSumSquare = 0;
        for(int i = 0; i < nums.length; i++){
            actualSum += (long)nums[i];
            actualSumSquare += (long)nums[i]*nums[i];  
        }
         long mMinusD=(long) idealSum - actualSum;
         long diffSumSquare =(long) idealSumSquare - actualSumSquare;

         long mPlusD = (long)diffSumSquare/mMinusD;
         int m = (int)(mPlusD+mMinusD)/2;
         int d = (int)(mPlusD-mMinusD)/2;

        return new int[]{d,m};
    }
}