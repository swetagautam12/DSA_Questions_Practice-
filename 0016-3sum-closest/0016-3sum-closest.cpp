class Solution {
public:
    int threeSumClosest(vector<int>& n, int target) {
       sort(n.begin(),n.end());
        int ans = 0;
        int prev = INT_MAX;
        int i = 0;
        while(i<n.size() - 2){
            int j = i + 1;
            int k = n.size() - 1;
            while(j<k){
                int sum = n[i] + n[j] + n[k];
                int d = abs(target - sum);
                if(d<prev){
                    prev = d;
                    ans = sum;
                
                }
                if(sum < target){
                    j++;
                    } else{
                    k--;
                }
            }
            i++;
        }
        
        return ans;
    }
};