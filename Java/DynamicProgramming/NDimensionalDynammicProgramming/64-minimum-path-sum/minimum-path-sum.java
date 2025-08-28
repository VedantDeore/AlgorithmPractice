class Solution {
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int prev[] = new int[m];
        for(int i=0;i<n;i++){
            int curr[] = new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j] = grid[0][0];
                }else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i>0) up += prev[j];
                    else up += (int)1e9;

                    if(j>0) left += curr[j-1];
                    else left += (int)1e9;

                    curr[j] = Math.min(up,left);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
}