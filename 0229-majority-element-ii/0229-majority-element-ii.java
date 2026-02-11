class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap <Integer,Integer>map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        List<Integer> lst=new ArrayList<>();
        int x=nums.length/3;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);

            }
            else{
                map.put(nums[i],1);
            }
            if(map.get(nums[i])>x){
                set.add(nums[i]);
            }

        }
        for(int values:set){
            lst.add(values);

        }
        return lst;
        
        
    }
}