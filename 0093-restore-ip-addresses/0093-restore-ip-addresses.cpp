class Solution {
public:
    int n;
    vector<string> res;

    bool isValid(string s)
    {
        if(s[0] == '0' && s.length() > 1) return false;

        int x = stoi(s);

        return x <= 255;
    }


    void solver(string &s, int parts, string curr,int i)
    {
        if(i >= n && parts == 4)
        {
            curr.pop_back();    // remove last '.'
            res.push_back(curr);
            return;
        }

        if(i+1 <= n)
        {
            solver(s,parts+1,curr + s.substr(i,1) +'.',i+1);
        }

        if(i+2 <= n && isValid(s.substr(i,2)))
        {   
            solver(s,parts+1,curr + s.substr(i,2) +'.',i+2);
        }

        if(i+3 <= n && isValid(s.substr(i,3)))
        {
            solver(s,parts+1,curr + s.substr(i,3) +'.',i+3);
        }
    }

    vector<string> restoreIpAddresses(string s) {
        n = s.length();
        // if(n > 12) return {};

        int parts = 0;
        string curr = "";
        solver(s,parts,curr,0);

        return res;
    }
};