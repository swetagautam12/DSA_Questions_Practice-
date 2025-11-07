class Solution {
public:
    bool check(vector<int> stations, long long mid, int k, int r){
        int n = stations.size();
        long long sum = 0;
        for(int i = 0; i < r; i++) sum += stations[i];
        for(int i = 0; i < n; i++){
            if(i+r < n) sum += stations[i+r];
            if(i-r-1 >= 0) sum -= stations[i-r-1];
            if(sum < mid){
                if(mid-sum > k)return false;
                if(i+r < n)stations[i+r] += mid-sum;
                k -= mid-sum;
                sum = mid;
            }
        }
        return true;
    }
    long long maxPower(vector<int>& stations, int r, int k) {
        long long lo = *min_element(begin(stations),end(stations));
        long long hi = accumulate(begin(stations),end(stations),0LL)+k;
        long long ans = 0;
        while(lo <= hi){
            long long mid = lo + (hi-lo)/2;
            if(check(stations,mid,k,r)){
                ans = mid;
                lo = mid+1;
            }else hi = mid-1;
        }
        return ans;
    }
};