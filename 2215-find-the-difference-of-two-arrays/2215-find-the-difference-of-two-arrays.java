class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for (int num:nums1)
        set1.add(num);
        for(int num:nums2)
        set2.add(num);
        List<Integer>List1= new ArrayList<>();
        List<Integer>List2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int num:set1){
            if(!set2.contains(num))
            List1.add(num);

        }
        for(int num :set2)
        {
            if(!set1.contains(num))
            List2.add(num);
        }
        ans.add(List1);
        ans.add(List2);
        return ans;
        
    }
}