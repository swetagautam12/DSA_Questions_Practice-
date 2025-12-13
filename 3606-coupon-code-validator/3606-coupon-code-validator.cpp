class Solution {
public:
    vector<string> validateCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        vector<pair<string,string> >ans;
        for(int i =0;i<code.size();i++){
            if(isActive[i] == true && (businessLine[i] == "electronics" || businessLine[i] == "grocery" || businessLine[i] == "pharmacy" || businessLine[i] == "restaurant"   ) && code[i].length() > 0){
                int chk =0;
                for(int j =0;j<code[i].length();j++){

                    if(code[i][j] != '_' && !isalpha(code[i][j]) && (code[i][j]-'0' < 0 || code[i][j]-'0' >=10)){
                        chk = 1;
                       break;
                    }
                }
                if(chk == 0){
                    cout<<code[i]<<endl;
                    ans.push_back(make_pair(businessLine[i],code[i]));
                }

            }
        }
        sort(ans.begin(),ans.end());
        vector<string>ans1;
        for(auto it:ans){
            ans1.push_back(it.second);
        }
        return ans1;
    }
};