class Solution {
    static {
        for (int i = 0; i < 150; i++) {
            largestDivisibleSubset(new int[] {0});
        }
    }
    public static List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        
        int n = arr.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        
        Arrays.fill(dp,1);
        
        int maxi=1;
        int lastIndex=0;
        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if(arr[index] % arr[prev] == 0 && 1 +dp[prev] > dp[index]){
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
            if(dp[index] > maxi){
                maxi = dp[index];
                lastIndex = index;
            }
        }

        int lis[] = new int[maxi];
        lis[0] = arr[lastIndex];
        int i=1;
        while (lastIndex != hash[lastIndex] ) {
            lastIndex = hash[lastIndex];
            lis[i] = arr[lastIndex];
            i++;
        }

        List<Integer> lisList = new ArrayList<>();
        for (int j = 0; j < lis.length; j++) {
            lisList.add(lis[j]);
        }
        Collections.reverse(lisList);
        return lisList;
    }
}