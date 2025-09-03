class Solution {
    public int countPrimes(int n) {
        if(n < 3)return 0;
        
        boolean prime[] = new boolean[n+1];
        // false = prime, true = composite

        int count = n / 2;  
        // all odds -> prime

        for(int i=3; i*i<n; i+=2){
            if (prime[i]) continue;
            for(int j= i*i; j<n; j+=2*i){
                if (!prime[j]) {
                    --count;     // found -> composite
                    prime[j] = true;
                }
            }
            
        }
        return count;
    }
}