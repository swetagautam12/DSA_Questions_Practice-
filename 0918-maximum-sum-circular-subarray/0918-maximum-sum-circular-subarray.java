class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 0)
        return 0;

        int result = nums[0];
        int maxsum = nums[0];
        int minsum = nums[0];
        int sumnums = nums[0];
        int resmin = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxsum = Math.max(maxsum + nums[i],nums[i]);
            minsum = Math.min(minsum + nums[i],nums[i]);
            sumnums += nums[i];

            result = Math.max(maxsum,result);
            resmin = Math.min(resmin,minsum);
        }
        if(sumnums != resmin)
        result = Math.max(result,sumnums - resmin);
        return result;
    }
}