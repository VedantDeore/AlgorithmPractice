class Solution {
    public int coinChange(int[] coins, int amount) {
        int prev[] = new int[amount+1];

        for(int T=0;T<=amount;T++){
            if(T % coins[0] == 0) prev[T] = T/coins[0];
            else prev[T] = (int)1e9; 
        }

        for(int index=1 ; index< coins.length; index++){
            int curr[] = new int[amount + 1];
            for(int T=0; T<= amount; T++){

                int notTake = 0 + prev[T];
                int take = (int)1e9;
                if(coins[index] <= T){
                    take = 1 + curr[T - coins[index]];
                }
                curr[T] = Math.min(take, notTake);
            }
            prev= curr;
        }
        
        return (prev[amount] >= (int)1e9) ? -1 : prev[amount];
    }
}