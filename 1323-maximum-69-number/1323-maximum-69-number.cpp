class Solution {
    #include<map>
public:
    int maximum69Number (int num) {
        map<int,int>mp;
        int i  = 0 ;
        int n  =0;
        while(num>0){
            int a = num%10;
            num=num/10;
            mp[i]=a;
           
            if (a==6)
            {
               n = max(n,i);  
            }i++;}
            mp[n]=9;
             int ans = 0;

    for (auto it = mp.rbegin(); it != mp.rend(); ++it) {
        ans = ans * 10 + it->second;
    } return ans; }
};