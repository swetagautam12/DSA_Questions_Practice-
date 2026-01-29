class Solution {
    public static void utilityFn(char[][] grid,boolean vis[][],int i,int j,int r,int c){
        //right
        if(j+1<c && grid[i][j+1]=='1' && !vis[i][j+1]){
            vis[i][j+1]=true;
            utilityFn(grid,vis,i,j+1,r,c);
        }
        //left
        if(j-1>=0 && grid[i][j-1]=='1' && !vis[i][j-1]){
            vis[i][j-1]=true;
            utilityFn(grid,vis,i,j-1,r,c);
        }
        //top
        if(i-1>=0 && grid[i-1][j]=='1' && !vis[i-1][j]){
            vis[i-1][j]=true;
            utilityFn(grid,vis,i-1,j,r,c);
        }
        //bottom
        if(i+1<r && grid[i+1][j]=='1' && !vis[i+1][j]){
            vis[i+1][j]=true;
            utilityFn(grid,vis,i+1,j,r,c);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int r=grid.length;
        int c=grid[0].length;
        boolean vis[][]=new boolean[r][c];
        int islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    vis[i][j]=true;
                    islands++;
                    utilityFn(grid,vis,i,j,r,c);
                }
            }
        }
        return islands; 
    }
}