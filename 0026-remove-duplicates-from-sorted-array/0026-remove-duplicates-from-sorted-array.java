class Solution {
    public int removeDuplicates(int[] nums) {
        var writePointer = 0;
        var scanPointer = 0; 

        while(scanPointer < nums.length){
            if(nums[scanPointer] != nums[writePointer]) nums[++writePointer] = nums[scanPointer];
            scanPointer++;
        }

        return ++writePointer;
    }
}