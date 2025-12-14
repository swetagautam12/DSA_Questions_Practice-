const int mod=1e9+7;
class Solution {
public:
    int numberOfWays(string corridor) {
        int seat=0;
        int n=corridor.size();
        for(auto it: corridor){
            if(it=='S') seat++;
        }
        if(seat&1 || seat==0 ) return 0;
        int ans=1;
         int l=0;
         int r=n-1;
         while(l<n && corridor[l]=='P') l++;
         while(r>=l && corridor[r]=='P') r--;
         if(l>r) return 0;
         int cntp=1;
         int seatcnt=0;
         bool start=false;
         while(l<=r){
            if(corridor[l]=='S') seatcnt++;
            if(seatcnt==1 && start==false){
                ans=(1ll*ans*cntp)%mod;
                start=true;
            }
            if(seatcnt==2){ seatcnt=0; cntp=0; start=false;}
            if(seatcnt==0) cntp++;
            l++;
        }
        return ans;
    }
};