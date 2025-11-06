class Solution {
public:
    int rob(vector<int>& nums, int n, vector<int>& memo) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (n == 1) return max(nums[0], nums[1]);
        if (memo[n] != -1) return memo[n];

        memo[n] = max(nums[n] + rob(nums, n - 2, memo), rob(nums, n - 1, memo));
        return memo[n];
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> memo(n, -1);
        return rob(nums, n - 1, memo);
    }
};