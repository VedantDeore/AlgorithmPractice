class Solution {
    public int change(int target, int[] coins) {
        int prev[] = new int[target+1];

        for(int T=0;T<=target;T++){
            prev[T] = (T % coins[0] == 0)? 1 :0;
        }

        for (int index = 1; index < coins.length; index++) {
            int curr[] = new int[target +1];
            for (int T = 0; T <= target; T++) {

                int notTake = prev[T];
                int take = 0;
                if(coins[index] <= T){
                    take = curr[T - coins[index]];
                }

                curr[T] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}