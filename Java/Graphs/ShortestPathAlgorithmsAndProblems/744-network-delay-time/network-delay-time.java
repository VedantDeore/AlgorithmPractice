class Solution {
    public int networkDelayTime(int [][]times, int n , int k){
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        int m=times.length;
        
        for (int i = 0; i <m; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adjList.get(u).add(new int[]{v, time});
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0; // src =0;
        dist[0] = 0; // 1 based indexing 
        // dist, node
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        q.add(new int[]{0,k});
        while (!q.isEmpty()) {
            int current[] = q.poll();
            int time = current[0];
            int node = current[1];

            for (int[] neighbour : adjList.get(node)) {
                int adjNode = neighbour[0];
                int edgeWeight = neighbour[1];
                if(time + edgeWeight < dist[adjNode]){
                    dist[adjNode] = time+ edgeWeight;
                    q.add(new int[]{time + edgeWeight, adjNode});
                }
            }
        }
        int mintime =0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == (int)1e9)return -1;
            else{
                mintime = Math.max(mintime, dist[i]);
            }
        }
        return mintime;
    }
}