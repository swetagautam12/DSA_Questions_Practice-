class Solution {
    public int findPeakElement(int[] nums) {

        int st=0,en= nums.length-1,mid=0;
        while(st<en){
            mid =(st+en)/2;
            if(nums[mid]<nums[mid+1]){
                st=mid+1;

            }else{
                en =mid;
            }
        }return st;
        
    }
}