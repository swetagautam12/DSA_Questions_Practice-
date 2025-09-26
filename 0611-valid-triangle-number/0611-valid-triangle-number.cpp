class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int cnt = 0;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i + 1; j < nums.size(); j++) {
                int sum = nums[i] + nums[j];
                int ind = lower_bound(nums.begin() + j + 1, nums.end(), sum) - nums.begin();
                cnt += (ind - j - 1);
            }
        }
        return cnt;
    }
};