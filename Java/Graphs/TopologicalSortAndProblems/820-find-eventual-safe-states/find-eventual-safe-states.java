class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjListRev = new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++){
            adjListRev.add(new ArrayList<>());
        }

        int indegree[] =new int[V];

        for(int i=0;i<V;i++){
            // i->neighbour
            // neighbour->i
            for(int neighbour : graph[i]){
                adjListRev.get(neighbour).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(Integer neighbour : adjListRev.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}