class Solution {
    public int maxProfit(int[] prices, int fee) {
        int next1=0, next0=0, curr1=0, curr0=0;
        int n = prices.length;
        for(int ind= n-1;ind>=0;ind--){
            curr1 = Math.max(-prices[ind] + next0, next1);
            curr0 = Math.max(prices[ind] - fee + next1, next0);
            next1 = curr1;
            next0 = curr0;
        }
        return next1;
    }
}