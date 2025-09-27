class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node){
        if(node == parent.get(node))return node;
 
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp); 
        return ulp;      
    }
       
    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));

        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
           
        }
    }
}

class Solution {
    
    public int findCircleNum(int[][] adjMatrix) {
        DisjointSet ds = new DisjointSet(adjMatrix.length);

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i+1; j < adjMatrix.length; j++) {
                if(adjMatrix[i][j] == 1){
                    ds.UnionBySize(i, j);
                }
            }
        }

        int cnt=0;

        for (int i = 0; i < adjMatrix.length; i++) {
            if(ds.findUParent(i) == i){
                cnt++;
            }
        }
        return cnt;
    }
}