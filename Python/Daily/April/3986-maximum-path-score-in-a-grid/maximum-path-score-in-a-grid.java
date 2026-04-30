class Solution {
    private int f(int i, int j,int grid[][], int k){
        
        if(i<0 || j <0 || k<0){
            return (int)-1e9;
        }

        if(i==0 && j== 0){
            int cost = (grid[i][j] == 0)?0:1;

            if(cost <= k){
                return (grid[0][0] == 0)?0 : (grid[0][0] == 1)?1:2;
            }else{
                return (int)-1e9;
            }
        }

        
        int currCost = (grid[i][j] == 0)?0:1;
        int currScore = (grid[i][j] == 0)?0 : (grid[i][j] == 1)?1:2;        
        
        int up = f(i-1,j,grid,k-currCost);
        int left = f(i,j-1,grid,k-currCost);

        return currScore + Math.max(up,left);
    }
    private int fmemoization(int i, int j,int grid[][], int k , int dp[][][]){
        
        if(i<0 || j <0 || k<0){
            return (int)-1e9;
        }

        if(i==0 && j== 0){
            int cost = (grid[i][j] == 0)?0:1;

            if(cost <= k){
                dp[i][j][k] =  (grid[0][0] == 0)?0 : (grid[0][0] == 1)?1:2;
            }else{
                dp[i][j][k] = (int)-1e9;
            }
        }

        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        int currCost = (grid[i][j] == 0)?0:1;
        int currScore = (grid[i][j] == 0)?0 : (grid[i][j] == 1)?1:2;        
        
        int up = fmemoization(i-1,j,grid,k-currCost,dp);
        int left = fmemoization(i,j-1,grid,k-currCost,dp);

        return dp[i][j][k] = currScore + Math.max(up,left);
    }

    private int ftabulation(int m, int n,int grid[][], int K){
       int dp[][][] = new int[m][n][K+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], (int) -1e9);
            }
        }

        for (int k = 0; k <= K; k++) {
            int cost = (grid[0][0] == 0)?0:1;

            if(cost <= k){
                dp[0][0][k] =  (grid[0][0] == 0)?0 : (grid[0][0] == 1)?1:2;
            }else{
                dp[0][0][k] = (int)-1e9;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= K ; k++) {

                    if(i==0 &&j==0){
                        continue;
                    }

                    int currCost = (grid[i][j] == 0)?0:1;
                    int currScore = (grid[i][j] == 0)?0 : (grid[i][j] == 1)?1:2;        
                    

                    int up = (int)-1e9; 
                    if(i-1>=0 && k - currCost >= 0 ) up = dp[i-1][j][k-currCost];
                    int left = (int)-1e9;
                    if(j-1>=0 && k - currCost >= 0) left = dp[i][j-1][k-currCost];

                    dp[i][j][k] = Math.max(dp[i][j][k], currScore + Math.max(up, left));
                }
            }
        }      
        int ans = -1;
        for (int k = 0; k <= K; k++) {
            ans = Math.max(ans, dp[m - 1][n - 1][k]);
        }

        return (ans < 0) ? -1 : ans;
    }
    public int maxPathScore(int[][] grid, int k) {
        int m= grid.length;
        int n = grid[0].length;

        return ftabulation(m,n,grid,k);
    }
}