class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int dp[] = new int[n];

        Arrays.fill(dp,1);
        
        int cnt[] = new int[n];

        Arrays.fill(cnt, 1);
        int maxi=1;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if(arr[prev] < arr[index] && 1 +dp[prev] > dp[index]){
                    dp[index] = 1 + dp[prev];
                    cnt[index] = cnt[prev];
                }else if(arr[prev] < arr[index] && 1 +dp[prev] == dp[index]){
                    cnt[index] += cnt[prev];
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }
        int nos = 0;
        for (int i = 0; i < cnt.length; i++) {
            if(dp[i] == maxi){
                nos += cnt[i];
            }
        }
        return nos;
    }
}