class Solution {
public:
    int areaOfMaxDiagonal(vector<vector<int>>& dimensions) {
        int max_area=0;
        int max_d=0;
        for (int i=0;i<dimensions.size();i++){
            int l=dimensions[i][0];
            int b=dimensions[i][1];
            int dl=(l*l)+(b*b);
            if (dl>max_d){
                max_d=dl;
                max_area=(l*b);
            }
            else if (dl==max_d){
                max_area=max(max_area, l*b);
            }
            
        }
        return max_area;
        
    }
};