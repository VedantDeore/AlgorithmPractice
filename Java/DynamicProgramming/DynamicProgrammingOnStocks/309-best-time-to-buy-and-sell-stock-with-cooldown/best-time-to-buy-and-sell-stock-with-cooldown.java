class Solution {
    public int maxProfit(int[] prices) {
        int next1=0;
        int next0=0;
        int nextgen1=0;
        int n = prices.length;
        for(int index= n-1;index>=0;index--){
            int curr1 = Math.max(-prices[index] + next0, next1);
            int curr0 = Math.max(prices[index] + nextgen1, next0);
            nextgen1 = next1;
            next0= curr0;
            next1= curr1;
        }
        return next1;
    }
}