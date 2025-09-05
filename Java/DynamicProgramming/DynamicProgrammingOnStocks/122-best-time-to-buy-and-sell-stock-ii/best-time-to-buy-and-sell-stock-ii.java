class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int next1 =0, next2 =0, curr1 =0, curr2 = 0;
        
        for(int i=n-1;i>=0 ;i--){
            curr1 = Math.max(-prices[i] + next2, next1);
            curr2 = Math.max(prices[i] + next1,next2);
            next1 = curr1;
            next2 = curr2;
        }
        return next1;
    }
}