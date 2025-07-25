class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row_arr[] = new boolean[matrix.length];
        boolean col_arr[]= new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row_arr[i]= col_arr[j]= true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row_arr[i] || col_arr[j]){
                    matrix[i][j] = 0;
                }
            }
        }
       

    }
}
  // for(int i=0;i<row_arr.length;i++){
        //     System.out.println(row_arr[i]);
        // }
        // for(int i=0;i<col_arr.length;i++){
        //     System.out.println(col_arr[i]);
        // }