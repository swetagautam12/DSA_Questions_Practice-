class Solution {
public:
    void func(int i, vector<int> &nums, vector<int> &subset, vector<vector<int>> &ans){
        ans.push_back(subset);
        for(int j = i; j < nums.size(); j++){
            
            if(j != i && nums[j] == nums[j - 1]) continue;
            subset.push_back(nums[j]);
            func(j + 1, nums, subset, ans);
            subset.pop_back();
        }
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> subset;
        sort(nums.begin(), nums.end());  
        func(0, nums, subset, ans);
        return ans;
    }
};