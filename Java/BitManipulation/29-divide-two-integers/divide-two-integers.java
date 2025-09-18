class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign =true;
        if(dividend <0 && divisor>0)sign = false;
        if(dividend >0 && divisor<0)sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;
        while (n >= d) {
            long temp = d, multiple = 1;
            while ((temp << 1) <= n) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;         
            ans += multiple;  
        }

        return sign ? (int) ans : (int) -ans;
    }
}