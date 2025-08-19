class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int m =prerequisites.length;
        for(int i=0;i<m;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int indegree[]= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(Integer neighbour:adjList.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(Integer neighbour : adjList.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if(i != numCourses) return new int[]{};
        return ans;
    }
}