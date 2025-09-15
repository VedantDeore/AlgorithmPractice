class Solution {
    private int shortestPath(int grid[][], int source[], int destination[], int n, int m){
        if(source[0] == destination[0] && source[1] == destination[1] ){
            return 0;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int dist[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[source[0]][source[1]] = 0;

        q.add(new int[]{0,source[0],source[1]});

        while(!q.isEmpty()){
            int current[] = q.poll();
            int distance = current[0];
            int row = current[1];
            int col = current[2];

            if(row == destination[0] && col == destination[1] ) return distance;

            int dr[] = {-1,0,1,0};
            int dc[] = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int nextr = row + dr[i];
                int nextc = col + dc[i];

                if(nextr>=0 && nextr<n && nextc >=0 && nextc <m){
                    int next = Math.max(distance , Math.abs(grid[nextr][nextc] - grid[row][col]));
                    if(next < dist[nextr][nextc]){
                        dist[nextr][nextc] = next;

                        q.add(new int[]{next,nextr,nextc});
                    }
                }
            }
        }
        return -1;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        return shortestPath(heights, new int[]{0,0}, new int[]{n-1,m-1},n,m);
    }
}