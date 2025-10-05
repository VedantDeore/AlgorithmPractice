class Solution {
    private int maxElement(int matrix[][], int mid){
        int maxIndex=0;
        for(int i=1;i<matrix.length;i++){
            if (matrix[i][mid] > matrix[maxIndex][mid]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int row = maxElement(mat,mid);
            int left = (mid-1>=0)? mat[row][mid-1]:-1;
            int right = (mid+1<m)? mat[row][mid+1]:-1;
            if(left < mat[row][mid] && mat[row][mid] > right){
                return new int[]{row,mid};
            }else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}