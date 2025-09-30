class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUParent(int node) {
        if (node == parent[node]) return node;

        int ulp = findUParent(parent[node]);
        parent[node] = ulp; // path compression
        return ulp;
    }

    public void UnionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    private boolean isValid(int row, int col, int n){
        return (row>=0 && row<n && col>=0 && col<n);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        
        DisjointSet ds = new DisjointSet(n*n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;

                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};

                for (int i = 0; i < 4; i++) {
                    int nextr = row + dr[i];
                    int nextc = col + dc[i];

                    if(isValid(nextr, nextc, n) && grid[nextr][nextc] == 1){
                        int nodeNo = row*n + col;
                        int adjNodeNo = nextr*n + nextc;

                        ds.UnionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int maxSize=0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 1) continue;

                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};

                HashSet<Integer> set = new HashSet<>();

                for (int i = 0; i < 4; i++) {
                    int nextr = row + dr[i];
                    int nextc = col + dc[i];

                    if(isValid(nextr, nextc, n) && grid[nextr][nextc] == 1){
                        int adjNodeNo = nextr*n + nextc;
                        set.add(ds.findUParent(adjNodeNo));                     
                    }
                }
                int sizeTotal =0;
                for (Integer adjComponents : set) {
                    sizeTotal += ds.size[adjComponents];
                }
                maxSize = Math.max(maxSize, sizeTotal + 1);
            }
        }

        for (int cellNo = 0; cellNo < n*n; cellNo++) {
            maxSize = Math.max(maxSize, ds.size[ds.findUParent(cellNo)]);
        }
        return maxSize;
    }
}