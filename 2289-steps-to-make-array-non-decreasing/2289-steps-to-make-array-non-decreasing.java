class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int res = 0;

        Stack<int[]> stack = new Stack<>(); 
        stack.push(new int[]{nums[n-1],0});

        for (int i = n-2; i >=0; i--) {
            int count=0;
            while(!stack.isEmpty()&&nums[i]>stack.peek()[0]){
                count=Math.max(count+1, stack.peek()[1]);
                stack.pop();
            }
            res=Math.max(count, res);
            stack.push(new int[]{nums[i],count});
        }

        return res;
    }
}