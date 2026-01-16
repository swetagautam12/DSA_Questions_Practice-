class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        hm.put(0,-1);
        for(int i =0; i<n;i++){
            sum=(sum+nums[i] )%k;
            if(sum<0) sum+=k;
            if(hm.containsKey(sum)) {
                if(i-hm.get(sum)>1) 
                return true;

            }
            else{
                hm.put(sum,i);

            }
        }
        return false ;
        
    }
}