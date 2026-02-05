class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        permuteCal(0, nums, li);
        return li;
    }

    public static void permuteCal(int index, int nums[], List<List<Integer>> li)
    {
        if(index == nums.length)
        {
            List<Integer> b=new ArrayList<>();
            for(int i : nums)
            b.add(i);

            li.add(b);
            return;
        }
        
        for(int i = index; i < nums.length; i++)
        {
            swap(i, index, nums);
            permuteCal(index+1, nums, li);
            swap(i, index, nums);
        }
    }

    public static void swap(int i, int j, int nums[])
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}