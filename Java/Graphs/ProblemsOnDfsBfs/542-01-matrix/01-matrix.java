class Node{
    int first;
    int second;
    int third;
    Node(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        
        int visited[][] = new int [n][m];
        int distance[][] = new int[n][m];

        Queue<Node> q = new LinkedList<Node>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i,j,0));
                    visited[i][j] = 1;
                }else{
                    visited[i][j] = 0;
                }
            }
        }

        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            distance[row][col] = steps;
            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow>=0 && nRow < n && nCol >=0 && nCol <m && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    q.add(new Node(nRow,nCol,steps+1));
                }
            }
        }
        return distance;
    }
}