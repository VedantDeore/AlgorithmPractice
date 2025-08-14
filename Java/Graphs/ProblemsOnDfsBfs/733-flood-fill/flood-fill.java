class Solution {
    private static void dfs(int row,int col, int ans[][], int initialColor, int newColor, int delRow[], int delCol[]){
        ans[row][col] = newColor;
        int n= ans.length;
        int m = ans[0].length;

        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && ans[nrow][ncol] == initialColor && ans[nrow][ncol] != newColor){
                dfs(nrow,ncol,ans,initialColor,newColor,delRow,delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = image;
        int initialColor = image[sr][sc];
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        dfs(sr,sc,ans,initialColor,color,delRow,delCol);
        return ans;
    }
}