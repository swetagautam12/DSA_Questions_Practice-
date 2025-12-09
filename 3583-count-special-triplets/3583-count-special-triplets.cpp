class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        const int mod = 1e9 + 7;
        long long cnt = 0;

        unordered_map<int , int> total;
        for (int num : nums) total[num]++;

        unordered_map<int , int> leftCnt;
        for (int num : nums) {
            total[num]--;
            
            cnt += (long long)leftCnt[2 * num] * total[2 * num];
            
            leftCnt[num]++;
        }
        return cnt % mod;
    }
};