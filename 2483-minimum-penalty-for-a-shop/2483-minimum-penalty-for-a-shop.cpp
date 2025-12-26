class Solution {
public:
    int bestClosingTime(string customers) {
        int n=customers.length();

            vector<int> pre(n + 1, 0);
        vector<int> suf(n + 1, 0);

        pre[0]=0;

        for(int i=0;i<n;i++)
        {
            pre[i+1]=pre[i]+((customers[i]=='N') ? 1:0 );
        }
        suf[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            suf[i]=suf[i+1]+((customers[i]=='Y') ? 1:0 );
        }

        int minlen=n;
        for(int i=0;i<=n;i++)
        {
            pre[i]+=suf[i];
            int len=pre[i];
            minlen=min(minlen,len);
        }
        for(int i=0;i<=n;i++)
        {
            int len=pre[i];
             if(len==minlen) return i;

        }
        return n;
    }
};