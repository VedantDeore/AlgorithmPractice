class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // node, dist
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i=0;i<m;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];
            adjList.get(u).add(new int[]{v,cost});
        }

        Queue<int[]> q = new LinkedList<>();
        // stops, node, dist
        q.add(new int[]{0,src,0});

        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int stops = current[0];
            int node = current[1];
            int cost = current[2];

            if(stops > k)continue;

            for(int[] neighbour: adjList.get(node)){
                int adjNode = neighbour[0];
                int edgeWeight = neighbour[1];
                if(cost + edgeWeight < dist[adjNode] && stops <= k){
                    dist[adjNode]  = cost + edgeWeight;
                    q.add(new int[]{stops + 1, adjNode, cost+edgeWeight});
                }
            }
        }
        if(dist[dst] == (int)1e9)return -1;
        return dist[dst];
    }
}