class Solution {
public:
    long long maximumHappinessSum(vector<int>& hapiness, int k) {
        sort(hapiness.rbegin(),hapiness.rend());
        long long ans=0;
        for(int i=0;i<k;i++){
            ans+=1LL*max(hapiness[i]-i,0);
        }
        return ans;
    }
};