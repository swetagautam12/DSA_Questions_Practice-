class Solution {
public:
int dp[101];
    bool check(char &a, char &b)
    {
        if(a == '1')return true;

        return ((a == '2')&&(b <= '6'));
    }

    int fun(int index, string &s)
    {
        if(index == s.size())return 1;
        if(dp[index] != -1)return dp[index];

        if(s[index] != '0')
        {
            int ans1 = fun(index+1,s);
            int ans2 = 0;

            if(index+1 < s.size() && check(s[index],s[index+1])){
                ans2 = fun(index+2,s);
            }
            return dp[index] = ans1+ans2;
        }
        return dp[index] = 0;
    }

    int numDecodings(string s) {
        if(s[0] == '0')return 0;

        for(int i=1;i<s.size();i++)
        {
            if(s[i] == '0' && s[i-1] > '2')return 0;
        }
        memset(dp,-1,sizeof(dp));
        int ans = fun(0,s);
        return ans;
    }
};