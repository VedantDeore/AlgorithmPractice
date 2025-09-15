class Solution {
    static class Tuple{
        int distance;
        int row;
        int col;
        Tuple(int first,int second,int third){
            this.distance = first;
            this.row = second;
            this.col = third;
        }
    }
    static {
        for (int i = 0; i < 150; i++) {
            shortestPathBinaryMatrix(new int[][] {{0}});
        }
    }
    private static int shortestPath(int grid[][], int source[], int destination[], int n, int m){
        if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1) return -1;
        if(source[0] == destination[0] && source[1] == destination[1]) return 1;

        Queue<Tuple> q = new LinkedList<>();
        
        int dist[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        } 

        dist[source[0]][source[1]] = 1;

        q.add(new Tuple(1,source[0],source[1]));

        while(!q.isEmpty()){
            Tuple current = q.poll();
            int distance = current.distance;
            int row = current.row;
            int col = current.col;

            // 8 directions
            int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
            int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};

            for(int i=0;i<8;i++){
                int nextr = row + dr[i];
                int nextc = col + dc[i];

                if(nextr>=0 && nextr<n && nextc>=0 && nextc<m){
                    if(grid[nextr][nextc] == 0 &&  1+ distance < dist[nextr][nextc] ){
                        dist[nextr][nextc] = 1 + distance;

                        if(nextr == destination[0] && nextc == destination[1] ) return 1 + distance;

                        q.add(new Tuple(1+distance, nextr, nextc));
                    }
                }
            }
        } 
        return -1;
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       return shortestPath(grid, new int[]{0,0}, new int[]{n-1,m-1},n,m);        
    }
}