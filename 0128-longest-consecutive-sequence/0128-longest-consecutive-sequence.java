class Solution {
    public int longestConsecutive(int[] nums) {

        int res = 0;
        Set <Integer>set = new HashSet<>();
        for(int i:nums) set.add(i);
        for(int i:nums){
            int max = 1, preval=i-1, nextVal =i+1;
            while(set.contains(preval)){
                max++;
                set.remove(preval--);

            }

            while(set.contains(nextVal)){
                max++;
                set.remove(nextVal++);

            }
            res=Math.max(res,max);

        }
        return res;
        
    }
}