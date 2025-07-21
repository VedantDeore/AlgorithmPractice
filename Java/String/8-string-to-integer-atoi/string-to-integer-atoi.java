class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        int ans = 0;
        int i = 0;
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;

            int digit = c - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
}
