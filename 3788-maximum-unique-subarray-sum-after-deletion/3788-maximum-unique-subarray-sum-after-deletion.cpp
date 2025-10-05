class Solution {
public:
    int maxSum(vector<int>& nums) {

        set<int> st;

        int maxi = INT_MIN;

        for(int n : nums){
            if(n > maxi) maxi = n;
            if(n >= 1) st.insert(n);
        }

        if(maxi < 0) return maxi;
        else{
            maxi = 0;
            for(auto x : st){
                maxi += x;
            }
        }

        return maxi;
    }
};