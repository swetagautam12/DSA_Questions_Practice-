class Solution {
public:
    vector<int> countMentions(int n, vector<vector<string>>& events) {
        vector <int> res(n , 0) ; 
        vector<pair <int , int> > online(n , {1,0}) ; 
        sort(events.begin(), events.end(), [](const vector<string>& a, const vector<string>& b) {
        int timeA = stoi(a[1]);
        int timeB = stoi(b[1]);
        if (timeA != timeB) {
            return timeA < timeB; 
        }
        return a[0] == "OFFLINE"; 
    });
        for (auto s : events){
            
                if (s[0] == "MESSAGE"){
                    if (s[2] == "ALL"){
                        for (int j = 0 ; j < n ; j++){
                            res[j]++ ; 
                        }
                             
                    }
                    else if (s[2] == "HERE"){
                        for (int j = 0 ; j < n ; j++){
                            if (online[j].first == 1) res[j]+=1 ; 
                            else {
                                if (stoi(s[1] ) - online[j].second >= 60 ){
                                    online[j] = {1,0} ; 
                                    res[j]++ ; 
                                }
                            }
                        }
                         
                    }
                    else {
                        for (int id = 0 ; id < s[2].length(); id++){
                            if (s[2][id] == 'd' and s[2][id-1] == 'i'){
                                int numid= 0 ;  
                                id++; 
                                while (id < s[2].length() and isdigit(s[2][id])){
                                    numid = numid*10 +  (s[2][id++] - '0') ; 
                                }
                                
                                res[numid] += 1 ;
                            }
                        
                        }  
                    }
                }
                else {
                    int numid = stoi(s[2]) ;
                    online[numid].first =  0 ; 
                    online[numid].second = stoi(s[1]); 
                    
                    
                    
                    
                }
            
        }
        return res ; 
    }
};