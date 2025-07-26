class Solution {
    public int Recursion(String s, int ans , int sign, int index){
        if(index>=s.length() || !Character.isDigit(s.charAt(index))){
            return sign*ans;
        }
        int digit = s.charAt(index) - '0';
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(ans > (max - digit)/10){
            return sign == -1?min:max;
        }
        ans = ans*10 + digit;
        index++;
        return Recursion(s,ans,sign,index);
    }
    public int myAtoi(String s) {
       int n = s.length();
       int sign = 1;
       int i=0;
       int ans=0;
       while(i<n && s.charAt(i) == ' '){
        i++;
       }
       if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
        sign = s.charAt(i) == '-'?-1:1;
        i++;
       }
       return Recursion(s,ans,sign,i);
    }
}
