class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // src -> [dst,cost]
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        int m = times.length;
        for(int i=0;i<m;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adjList.get(u).add(new int[]{v,time});
        }

        // time, src, dist
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,k,0});

        int dist[] = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;
        dist[0] = 0;
        while(!q.isEmpty()){
            int current[] = q.poll();
            int time = current[0];
            int node = current[1];
            int distance = current[2];

            for(int[] neighbour : adjList.get(node)){
                int adjNode = neighbour[0];
                int edgeWeight = neighbour[1]; // travel time
                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance+edgeWeight;
                    q.add(new int[]{time +1, adjNode, distance+edgeWeight});
                }
            }
        }
        int time=0;
        for(int i=0;i<=n;i++){
            if(dist[i] == (int)1e9)return -1;
            else{
                time = Math.max(time, dist[i]);
            }
        }
        return time;
    }
}