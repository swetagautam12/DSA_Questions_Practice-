class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];
        int isLands = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    isLands++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return isLands;
    }
    static void bfs(int r,int c,char [][] grid, boolean [][]visited){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        visited[r][c] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int [] d:dirs){
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length 
                && nc < grid[0].length && grid[nr][nc] == '1'
                 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}