class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         int dist[][] = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, (int)1e9);
        }
        int m =  edges.length;
        for (int i = 0; i < m; i++) {
           int u = edges[i][0];
           int v = edges[i][1];
           int edgeWeight = edges[i][2];
           dist[u][v] = edgeWeight;
           dist[v][u] = edgeWeight;
        }

        for(int i=0;i<n;i++)dist[i][i] =0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] == (int)1e9 || dist[k][j] == (int)1e9)continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int cntCity = n;
        int cityNo =-1;
        for (int city = 0; city < n; city++) {
            int cnt=0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}