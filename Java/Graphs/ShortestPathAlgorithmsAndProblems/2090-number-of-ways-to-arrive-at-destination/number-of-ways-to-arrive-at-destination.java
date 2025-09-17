class Solution {
    public int countPaths(int n, int[][] roads) {
        // node,dist
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int distance = roads[i][2];
            adjList.get(u).add(new int[]{v, distance});
            adjList.get(v).add(new int[]{u, distance});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;


        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        // node,dist
        q.add(new long[]{0L, 0L});

        int mod = 1_000_000_007;

        while (!q.isEmpty()) {
            long current[] = q.poll();
            int node = (int)current[0];
            long distance = current[1];

            if (distance > dist[node]) continue;
            
            for (int neighbour[] : adjList.get(node)) {
                int adjNode = neighbour[0];
                long edgeWeight = (long) neighbour[1];

                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;

                    ways[adjNode] = ways[node];

                    q.add(new long[]{adjNode, distance +edgeWeight});

                }else if(distance + edgeWeight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }
            }
        }
        return (int) ways[n-1]%mod;
    }
}