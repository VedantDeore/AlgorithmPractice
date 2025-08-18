class Solution {
    private boolean check(int start,int V,  int adjList[][], int color[] ){
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(start);

      color[start] = 0;

      while(!q.isEmpty()){
        int node = q.peek();
        q.remove();

        for(int neighbour : adjList[node]){

              if(color[neighbour] == -1){
                color[neighbour] = 1- color[node];
                q.add(neighbour);
              }else if(color[neighbour] == color[node]){
                return false;
              }
        }
      }
      return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++)color[i] = -1;

        for(int i=0;i<color.length;i++){
          if(color[i] == -1){
            if(check(i, graph.length, graph,color) == false){
              return false;
            }
          }
        }

        return true;
    }
}