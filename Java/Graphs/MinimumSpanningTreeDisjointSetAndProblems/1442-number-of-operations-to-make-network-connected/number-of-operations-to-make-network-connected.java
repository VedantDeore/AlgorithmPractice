class DisjointSet{
    // ArrayList<Integer> parent = new ArrayList<>();
    // ArrayList<Integer> size = new ArrayList<>();
    int parent[];
    int size[];
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUParent(int node){
        if(node == parent[node])return node;

        int ulp = findUParent(parent[node]);
        parent[node]  = ulp; 
        return ulp;      
    }

    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;

        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] =  size[ulp_v] + size[ulp_u];

        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] =  size[ulp_u] + size[ulp_v];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if(ds.findUParent(u) == ds.findUParent(v)){
                extraEdges++;
            }else{
                ds.UnionBySize(u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if(ds.parent[i] == i){
                components++;
            }
        }

        int ans = components - 1;
        return (extraEdges >= ans) ? ans : -1;
    }
}