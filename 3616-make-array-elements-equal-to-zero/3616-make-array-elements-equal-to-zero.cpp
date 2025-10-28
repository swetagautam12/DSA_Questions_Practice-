class Solution {
public:
    int countValidSelections(vector<int>& nums) {
        int ans = 0, curr = 0, tot = 0;
        tot = accumulate(nums.begin(), nums.end(), 0);
        for(size_t i = 0; i < nums.size(); ++i)
        {
            curr += nums[i];
            if(nums[i] == 0 && curr*2 == tot)
                ans += 2;
            else if(nums[i] == 0 && abs(tot - 2 * curr) == 1)
                ++ans;
        }
        return ans;
    }
};