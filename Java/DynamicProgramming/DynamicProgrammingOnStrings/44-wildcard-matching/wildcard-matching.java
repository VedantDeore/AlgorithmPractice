class Solution {
    public boolean isMatch(String s2, String s1) {
        int n = s1.length();
        int m = s2.length();

        boolean prev[] = new boolean[m+1];

        prev[0] = true;

        for(int i=1 ;i<=n;i++){

            boolean curr[] = new boolean[m+1];

            curr[0] = (s1.charAt(i-1) == '*') && prev[0];

            for(int j=1;j<=m;j++){

                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?' ){
                    curr[j] = prev[j-1];
                }else{
                    if(s1.charAt(i-1) == '*'){
                        curr[j] = prev[j] || curr[j-1];
                    }else{
                        curr[j] = false;
                    }
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}