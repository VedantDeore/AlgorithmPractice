class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        Queue<Pair> q = new LinkedList<Pair>();
        // corner row, col
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && (i==0 || j==0 || i== m-1 || j==n-1)){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i=0;i<4;i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow>=0&& nrow<m && ncol>=0 && ncol<n && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                }
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