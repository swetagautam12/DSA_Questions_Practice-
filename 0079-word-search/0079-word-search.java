class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][]visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,word,0,i,j,visited))return true;
            }
        }
        return false;
    }
    public boolean helper(char[][]board,String word,int index,int row,int col,boolean[][]visited){
        if(index==word.length())return true;
        if(row>=board.length||col>=board[0].length)return false;
        if(row<0||col<0)return false;
        if(word.charAt(index)!=board[row][col])return false;
        if(visited[row][col])return false;
        visited[row][col]=true;
        boolean left= helper(board,word,index+1,row,col+1,visited);
        boolean down= helper(board,word,index+1,row+1,col,visited);
        boolean right=helper(board,word,index+1,row,col-1,visited);
        boolean up=helper(board,word,index+1,row-1,col,visited);
        visited[row][col]=false;
        return left||down||right||up;

    }
}