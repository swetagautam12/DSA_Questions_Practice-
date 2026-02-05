class Solution {
    public static void solve(List<Integer> currList, List<List<Integer>> ans, int[] nums, int target, int index, int currSum){
        if(index>nums.length-1){
            return;
        }
        if(currSum==target){
            ans.add(new ArrayList<>(currList));
            return;
        }

        //pick
        if(currSum+ nums[index]<=target){
            currList.add(nums[index]);
            solve(currList, ans, nums, target, index, currSum+nums[index]);
            currList.remove(currList.size()-1);
        }

        //not pick
        solve(currList, ans, nums, target, index+1, currSum);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        solve(currList, ans, candidates, target,0, 0);
        return ans;
    }
}