class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        int js = 0;
        vector<bool> mp;
        for (int i = 0; i < nums.size(); i++) {
            js = (js * 2 + nums[i]) % 5;
            if (js == 0) {
                mp.push_back(true);
            } else {
                mp.push_back(false);
            }
        }
        return mp;
    }
};
