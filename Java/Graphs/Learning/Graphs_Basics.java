import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class BreadthFirstSearch{
    public ArrayList<Integer> breadthFirstSearchGraph(int V, ArrayList<ArrayList<Integer>> adjList, int startNode){

        ArrayList<Integer> bfs = new ArrayList<>();

        boolean visited[] = new boolean[V];
        
        Queue<Integer> q = new LinkedList<>();

        
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
           Integer node = q.poll();
           bfs.add(node);
           
           for (Integer neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
           }
        }
        return bfs;
    }   
    
    // Overloaded method for backward compatibility - defaults to starting from node 1
    public ArrayList<Integer> breadthFirstSearchGraph(int V, ArrayList<ArrayList<Integer>> adjList){
        return breadthFirstSearchGraph(V, adjList, 1);
    }
}

class DepthFirstSearch{
    public void depthFirstSearch(int node, boolean visited[], ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for (Integer neighbour : adjList.get(node)) { // iterate over neighbors
            if (visited[neighbour] == false) {
                depthFirstSearch(neighbour, visited, adjList, dfs);
            }
        }
    }
    
    // Convenience method that returns the DFS traversal directly
    public ArrayList<Integer> depthFirstSearchGraph(int V, ArrayList<ArrayList<Integer>> adjList, int startNode) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[V];
        depthFirstSearch(startNode, visited, adjList, dfs);
        return dfs;
    }
}

class CountGraphComponents{
    public int CountComponents(int n, int edges[][]){
            List<List<Integer>> adjlist = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjlist.add(new ArrayList<>());
            }
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                adjlist.get(u).add(v);
                adjlist.get(v).add(u);
            }

            boolean visited[] = new boolean[n];
            int count =0;
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    //dfs(i,adjlist,visited);
                    count++;
                }
            }
            return count;
        }
}

public class Graphs_Basics {
    public static void PrintAdjacencyMatrix(int adjmatrix[][], int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adjmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void AdjacencyMatrix(int n,int m, int edges[][]){
        int adjmatrix[][] = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjmatrix[u][v] = 1;
            adjmatrix[v][u] = 1;
        }
        PrintAdjacencyMatrix(adjmatrix, n);
    }
    public static void PrintAdjacencyList(ArrayList<ArrayList<Integer>> adjlist, int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjlist.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    public static void AdjacencyListUndirected(int n, int m, int edges[][]){
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        PrintAdjacencyList(adjlist, n);
    }
    public static void AdjacencyListDirected(int n, int m, int edges[][]){
         ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
        }

        PrintAdjacencyList(adjlist, n);
    }
    static class Pair {
        int node;
        int weight;
        
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void PrintWeightedAdjacencyList(ArrayList<ArrayList<Pair>> adjListWeighted, int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (Pair p : adjListWeighted.get(i)) {
                System.out.print("(" + p.node + ", " + p.weight + ") ");
            }
            System.out.println();
        }
    }
    public static void AdjacencyListWeighted(int n, int m, int weightededges[][]){
        // undirected 
        ArrayList<ArrayList<Pair>> adjListWeighted = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjListWeighted.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = weightededges[i][0];
            int v = weightededges[i][1];
            int weight = weightededges[i][2];

            adjListWeighted.get(u).add(new Pair(v, weight));
            adjListWeighted.get(v).add(new Pair(u, weight));
        }
        PrintWeightedAdjacencyList(adjListWeighted, n);
    }
    public static ArrayList<ArrayList<Integer>> AdjacencyListUndirectedGlobal(int n, int m, int edges[][]){
          ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        //PrintAdjacencyList(adjlist, n);
        return adjlist;
    }
    public static void PrintList(ArrayList<Integer> list){
        for (int integer : list) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int edges[][] = {{1,2},{1,3},{2, 3},{2, 4},{3, 5},{4, 5}};
        int weightededges[][] = {{1,2,3},{1,3,5},{2,3,7},{2,4,1},{3,5,8},{4,5,9}};
        // AdjacencyMatrix(n, m, edges);
        // AdjacencyListUndirected(n, m, edges);
        // AdjacencyListDirected(n, m, edges);
        // AdjacencyListWeighted(n, m, weightededges);

        // Counting Components
            // CountGraphComponents cc = new CountGraphComponents();
            // int n1 = 5;
            // int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}, {3,1}, {0,3}};
            // System.out.println(cc.CountComponents(n1, edges1)); // Output: 2

            // int n2 = 5;
            // int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
            // System.out.println(cc.CountComponents(n2, edges2)); // Output: 1

        // Breadth First Search
            BreadthFirstSearch bfsSearch = new BreadthFirstSearch();
            ArrayList<ArrayList<Integer>> adjList1 = AdjacencyListUndirectedGlobal(n, m, edges);
            
            System.out.println("BFS traversal starting from node 1:");
            ArrayList<Integer> bfsResult = bfsSearch.breadthFirstSearchGraph(n + 1, adjList1, 1);
            PrintList(bfsResult);
            
        // Depth First Search  
            DepthFirstSearch dfsSearch = new DepthFirstSearch();
            ArrayList<ArrayList<Integer>> adjList2 = AdjacencyListUndirectedGlobal(n, m, edges);
            
            System.out.println("DFS traversal starting from node 1:");
            ArrayList<Integer> dfsResult = dfsSearch.depthFirstSearchGraph(n + 1, adjList2, 1);
            PrintList(dfsResult);
            
            System.out.println("DFS traversal starting from node 3:");
            ArrayList<Integer> dfsResult2 = dfsSearch.depthFirstSearchGraph(n + 1, adjList2, 3);
            PrintList(dfsResult2);
    }
}
