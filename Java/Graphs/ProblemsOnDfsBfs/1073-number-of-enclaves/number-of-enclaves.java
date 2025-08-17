class Solution {
    private void dfs(int row,int col,int grid[][],boolean visited[][], int delRow[],int delCol[]){
        visited[row][col] = true;

        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >=0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol] == 1 ){
                dfs(nrow,ncol,grid,visited,delRow,delCol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        // col
        for(int j = 0;j<n;j++){
            
            if(!visited[0][j] && grid[0][j] == 1){
                dfs(0,j,grid,visited,delRow,delCol);
            }

            if(!visited[m-1][j] && grid[m-1][j] == 1){
                dfs(m-1,j,grid,visited,delRow,delCol);
            }
        }

        // row
        for(int i=0;i<m;i++){
            
            if(!visited[i][0] && grid[i][0] == 1){
                dfs(i,0,grid,visited,delRow,delCol);
            }

            if(!visited[i][n-1] && grid[i][n-1] == 1){
                dfs(i,n-1,grid,visited,delRow,delCol);
            }
        }

        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}