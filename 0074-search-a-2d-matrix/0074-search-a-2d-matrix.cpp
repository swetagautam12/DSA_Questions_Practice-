class Solution {
public:
    bool searchMatrix(vector<vector<int>>& mat , int t) {
        int n = mat.size(), m = mat[0].size();
        int s = 0 , e = n*m - 1;

        while( s <= e){
           int mid = s + ( e - s)/2;
           int row = mid / m;
           int col = mid % m;
           if( mat[row][col] == t) return true;
           else if(mat[row][col] < t){
               s  = mid + 1;
           }else{
               e = mid - 1;
           }
        }  return false;

    }
};