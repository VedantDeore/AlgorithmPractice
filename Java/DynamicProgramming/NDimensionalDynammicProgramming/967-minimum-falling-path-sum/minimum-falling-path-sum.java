class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int prev[] = new int[m];

        for(int j=0;j<m;j++){
            prev[j] = matrix[0][j];
        }

        for(int i=1;i<n;i++){
            int curr[] = new int[m];
            for(int j=0;j<m;j++){
                int s = prev[j];

                int ld= (j>0)? prev[j-1] : (int)1e9;

                int rd= (j<m-1)? prev[j+1] : (int)1e9;

                curr[j] = matrix[i][j] + Math.min(s, Math.min(ld,rd));
            }
            prev = curr;
        }
        int max= Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            max=Math.min(max,prev[j]);
        }
        return max;
    }
}