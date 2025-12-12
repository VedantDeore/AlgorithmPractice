class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        next1 =0
        next2 =0
        curr1 =0
        curr2 = 0
        
        for i in range(n-1,-1,-1):
            curr1 = max(-prices[i] + next2, next1)
            curr2 = max(prices[i] + next1,next2)
            next1 = curr1
            next2 = curr2
        return next1