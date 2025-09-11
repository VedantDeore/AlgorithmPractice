class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int arr[] = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i=1;i<=m;i++){
            arr[i] = cuts[i-1];
        }
        Arrays.sort(arr);

        int dp[][]= new int[m+2][m+2];

        for(int i=m;i>=1;i--){
            for(int j=1;j<=m;j++){
                if(i>j)continue;

                int mincost = (int)1e9;
                for(int ind = i;ind<=j;ind++){
                    int cost = (arr[j+1] - arr[i-1]) + dp[i][ind-1] + dp[ind+1][j];
                    mincost = Math.min(cost,mincost);
                }
                dp[i][j] = mincost;
            }
        }
        return dp[1][m];
    }
}