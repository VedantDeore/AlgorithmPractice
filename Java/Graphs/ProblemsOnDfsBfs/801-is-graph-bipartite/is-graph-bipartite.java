class Solution {
    private boolean dfs(int node,int currentColor,  int adjList[][], int color[] ){
      color[node] = currentColor;
        
        for(int neighbour : adjList[node]){

              if(color[neighbour] == -1){
                  if(dfs(neighbour, 1-currentColor, adjList,color) == false){
                    return false;
                  }
              }else if(color[neighbour] == color[node]){
                return false;
              }
        }
      return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++)color[i] = -1;

        for(int i=0;i<color.length;i++){
          if(color[i] == -1){
            if(dfs(i,0, graph,color) == false){
              return false;
            }
          }
        }

        return true;
    }
}