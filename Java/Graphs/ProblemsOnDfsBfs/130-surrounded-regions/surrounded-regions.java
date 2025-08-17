class Solution {
    private void dfs(int row, int col, char[][] board, boolean visited[][], int delRow[], int delCol[]){
        visited[row][col] = true;

        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow>=0 && nrow < board.length && ncol >=0 && ncol < board[0].length && !visited[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,board,visited,delRow,delCol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        // first and the last row
        for(int j=0; j<m;j++){
            if(!visited[0][j] && board[0][j] == 'O'){
                dfs(0,j,board,visited,delRow,delCol);
            }

            if(!visited[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1,j,board,visited, delRow,delCol);
            }
        }

        // traverse the first and last col
        for(int i=0;i<n;i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0,board,visited,delRow,delCol);
            }

            if(!visited[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,board,visited,delRow,delCol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }
}