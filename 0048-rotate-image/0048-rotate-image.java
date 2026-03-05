class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for(int i=0;i<matrix[0].length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }
}