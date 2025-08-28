class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int prev[] = new int[m];

        for(int i=0;i<n;i++){
            int curr[] = new int[m];
            for(int j=0;j<m;j++){
                if(i>=0 && j>=0 && obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                }else if(i==0 && j==0){
                    curr[j] = 1;
                }else{
                    int up=0;
                    int left=0;

                    if(i>0) up= prev[j];
                    if(j>0) left = curr[j-1];
                    
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
}