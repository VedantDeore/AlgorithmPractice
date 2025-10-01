class Solution {
    private int timer=0;

    private void dfs(int node,int parent,int visited[],ArrayList<ArrayList<Integer>> adjList,int time[],int low[],List<List<Integer>> bridges){
        visited[node] =1;
        time[node] = low[node] = timer;
        timer++;

        for (Integer neighbour : adjList.get(node)) {
            if(neighbour == parent){
                continue;
            }
            if(visited[neighbour] == 0){
                dfs(neighbour, node, visited, adjList, time, low, bridges);

                low[node] = Math.min(low[node], low[neighbour]);

                // neighbour ---- node
                if(low[neighbour] > time[node]){
                    bridges.add(Arrays.asList(node, neighbour));
                }
            }else{
                low[node] = Math.min(low[node], low[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int visited[] = new int[n];
        int time[] = new int[n];
        int low[] = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,visited,adjList,time, low, bridges);

        return bridges;
    }
}