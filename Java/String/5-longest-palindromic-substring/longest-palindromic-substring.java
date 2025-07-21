class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                boolean isPallindrome = true;
                int p1 = i;
                int p2 = j;
                while(p1<p2){
                    if(s.charAt(p1) != s.charAt(p2)){
                        isPallindrome = false;
                        break;
                    }
                   p1++;
                   p2--;
                }
                if(isPallindrome && (j-i+1)> max){
                    max = j-i+1;
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}