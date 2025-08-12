class Pair{
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        int visited[][] = new int[n][m];
        int countFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }
                
                if(grid[i][j] == 1)countFresh++;
            }
        }

        int time=0;
        int di[] = {-1,0,1,0};
        int dj[] = {0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(t,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r + di[i];
                int ncol = c + dj[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol, t+1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != countFresh)return -1;
        return time;
    }
}