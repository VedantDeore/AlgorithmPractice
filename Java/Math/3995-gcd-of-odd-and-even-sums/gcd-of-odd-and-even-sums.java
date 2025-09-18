class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a = n*n;
        int b = n*(n+1);
        while (a>0 && b>0) {
            if(a>b) a = a%b;
            else b = b%a;

        }
        if (a ==0 )return b;
        else return a;
    }
}