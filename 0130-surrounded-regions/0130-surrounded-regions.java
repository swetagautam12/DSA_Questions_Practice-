class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int n= board.length;
        int m= board[0].length;
        boolean[][] visited= new boolean[n][m];
        List<List<Integer>> lists= new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O' && !visited[i][j] ){
                    if(!solve(board, i, j, n, m, visited)){
                        lists.add(Arrays.asList(i,j));
                    }
                }
            }
        }
        for(List<Integer> list: lists){
            int i= list.get(0);
            int j= list.get(1);
            solve2(board, i, j, n, m);
        }
    }
    public boolean solve(char[][] board, int i, int j, int n, int m, boolean[][] visited){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        boolean res = (i == 0 || i == n - 1 || j == 0 || j == m - 1);
        while(!q.isEmpty()){
            int[] u= q.poll();
            int r=u[0];
            int c=u[1];
            int[][] directions= {{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] dir: directions){
                int nr= r+dir[0];
                int nc= c+dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]=='O' && !visited[nr][nc]){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                    if(nr == 0 || nr == n-1 || nc == 0 || nc == m-1){
                        res=true;
                    }
                }
            }
        }
        return res;
    }
    public void solve2(char[][] board, int i, int j, int n, int m){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i,j});
        boolean[][] vis= new boolean[n][m];
        vis[i][j]=true;
        board[i][j]='X';
        while(!q.isEmpty()){
            int[] u= q.poll();
            int r=u[0];
            int c=u[1];
            int[][] directions= {{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] dir: directions){
                int nr= r+dir[0];
                int nc= c+dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]=='O' && !vis[nr][nc]){
                    q.add(new int[]{nr,nc});
                    vis[nr][nc]=true;
                    board[nr][nc]='X';
                }
            }
        }
    }
}