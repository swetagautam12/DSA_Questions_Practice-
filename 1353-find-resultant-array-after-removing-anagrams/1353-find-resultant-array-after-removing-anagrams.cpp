class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        int i=1;
        while(i<words.size()){
            string a=words[i],b=words[i-1];
            sort(a.begin(),a.end());
            sort(b.begin(),b.end());
            if(a==b)words.erase(words.begin()+i);
            else i++;
        }
        return words;
    }
};