class Solution {
    public int countPrimes(int n) {
        if(n <= 2)return 0;
        int prime[] = new int[n+1];

        Arrays.fill(prime, 1); 
        prime[0] = 0;
        prime[1] = 0;

        for(int i=2; i*i<=n;i++){
            if(prime[i] == 1){
                for(int j= i*i; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }

        int cnt=0;
        for(int i =2 ;i<n;i++){
            if(prime[i] == 1){
                cnt++;
            }
        }
        return cnt;
    }
}