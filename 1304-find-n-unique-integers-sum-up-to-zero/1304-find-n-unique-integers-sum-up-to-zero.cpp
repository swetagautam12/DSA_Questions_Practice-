class Solution {
public:
    vector<int> sumZero(int n) {
        unordered_set<int>st;
        if(n%2!=0){
            st.insert(0);
            int i=1;
            while(st.size()<n){
                st.insert(i);
                st.insert(-i);
                i++;
            }
        }else{
            int i=1;
            while(st.size()<n){
                st.insert(i);
                st.insert(-i);
                i++;
            }
        }
        vector<int>ans;
        for(auto it:st){
            ans.push_back(it);
        }
        return ans;
    }
};