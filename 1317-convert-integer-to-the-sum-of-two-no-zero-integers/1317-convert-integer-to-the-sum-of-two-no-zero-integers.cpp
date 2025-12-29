class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        for(int a = 1; a < n; a++){
            int b = n - a;
            if(hasZero(a) && hasZero(b)) {
                return {a, b};
            }
        }
        return {};
    }
    bool hasZero(int x){
        while(x > 0){
            if(x%10 == 0) return false;
            x = x/10;
        }
        return true;
    }
};