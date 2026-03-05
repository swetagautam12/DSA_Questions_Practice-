class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length,low=1,high=position[n-1]-position[0],ans=0;        
        while (low <= high) {
            int mid =(high+low)/2;
            if (canPlace(position,mid,m,n)){
                ans=mid;
                low = mid + 1;
            }
            else high = mid - 1;            
        }
    return ans;
    }
    public boolean canPlace(int[] pos, int dis,int m,int n) {
        int count = 1,lastplaced=pos[0];
        for (int i=1;i<n;i++) {
            if (pos[i]-lastplaced>=dis) {
                count++;
                lastplaced=pos[i];
                if(count>=m)return true;
            }
        }
        return false;
    }
}