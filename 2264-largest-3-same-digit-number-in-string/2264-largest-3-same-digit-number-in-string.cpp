class Solution {
public:
    string largestGoodInteger(string num) {
        string ans;
        char a;
        int n=num.size();
        for(int i=0;i<n-2;i++){
            a=num[i];
            if(num[i+1]==a && num[i+2]==a) ans = max(ans, num.substr(i, 3));}
        return ans;
    }
};