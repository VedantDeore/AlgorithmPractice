class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if(arr[prev] < arr[index]){
                    dp[index] = Math.max( 1 + dp[prev], dp[index]);
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }
        return maxi;
    }
}