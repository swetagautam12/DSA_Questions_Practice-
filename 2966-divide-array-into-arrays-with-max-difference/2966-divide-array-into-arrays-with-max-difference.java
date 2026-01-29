class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length/3][3];
        Arrays.sort(nums);
        int j=0;
        for(int i=0;i<nums.length;i+=3){
            if(nums[i+1] - nums[i] <=k && nums[i+2]-nums[i+1] <=k && nums[i+2]-nums[i] <=k){
                ans[j][0] = nums[i];
                ans[j][1] = nums[i+1];
                ans[j][2] = nums[i+2];
                j++;
            }
            else return new int[][]{};
        }
    return ans;
    }
}
  