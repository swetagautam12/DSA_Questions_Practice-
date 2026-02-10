class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0, n = nums.length;
        for(int i=0;i<n;i++) xor ^= nums[i];

        int pos = xor & (-xor);

        int a=0,b=0;
        for(int i=0;i<n;i++){
            if((nums[i] & pos)==0) a ^= nums[i];
            else b ^= nums[i];
        }
        int arr[] = new int[2];
        arr[0] = a;
        arr[1] = b;

        return arr;
    }
}