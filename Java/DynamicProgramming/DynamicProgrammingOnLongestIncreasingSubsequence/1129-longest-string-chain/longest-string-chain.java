class Solution {

    private boolean checkPossible(String s1, String s2){
        if(s1.length()- s2.length() == 1){
            int first = 0;
            int second = 0;
            while (first < s1.length()) {
                if( second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                    first++;
                    second++;
                }else{
                    first++;
                }
            }

            if(first == s1.length() && second == s2.length()){
                return true;
            }
        }
        return false;
        
    }
    Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public int longestStrChain(String[] arr) {
        int n = arr.length;

        int dp[] = new int[n];

        Arrays.sort(arr,comp);

        Arrays.fill(dp,1);
        int maxi=1;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if( checkPossible(arr[index], arr[prev]) && 1 +dp[prev] > dp[index]){
                    dp[index] = 1 + dp[prev];
                }
            }
            if(dp[index] > maxi){
                maxi = dp[index];
            }
        }

        return maxi;
    }
}