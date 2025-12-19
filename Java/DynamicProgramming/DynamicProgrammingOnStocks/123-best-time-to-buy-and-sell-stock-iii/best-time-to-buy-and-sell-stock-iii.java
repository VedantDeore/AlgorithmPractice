class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int next[] = new int[5];

        for(int index = n-1;index>=0;index--){
            int curr[] = new int[5];
            for(int transaction=0 ; transaction<=3 ; transaction++){
                if(transaction %2 ==0){
                    curr[transaction] = Math.max(-prices[index]+ next[transaction+1], next[transaction]);
                }else{
                    curr[transaction] = Math.max( prices[index]+ next[transaction+1], next[transaction]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}