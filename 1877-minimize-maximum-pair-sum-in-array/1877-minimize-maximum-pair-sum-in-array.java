class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length-1;
        Arrays.sort(nums);
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i<n){
            int sum = nums[n]+nums[i];
            if(max < sum){
                max = sum;
            }
            i++;
            n--;
        }
        return max;
    }
}