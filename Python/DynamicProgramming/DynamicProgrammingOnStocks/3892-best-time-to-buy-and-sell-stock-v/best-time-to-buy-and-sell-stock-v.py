class Solution:
    def maximumProfit(self, prices: List[int], k: int) -> int:
        n = len(prices)
        capp = k
        m = capp
        # dp  = [[[0]*(m+1) for _ in range(3) ] for _ in range(n+1)]
        next  = [[0]*(m+1) for _ in range(3) ]
        


        HOLD = 0
        BUY = 1
        SELL = 2
        
    
        for buy in range(3):
            for cap in range(capp+1):
                
                if buy == HOLD:
                    next[buy][cap] = 0
 
                if buy == BUY:
                    next[buy][cap] = +prices[n-1]

                if buy == SELL:
                    next[buy][cap] = -prices[n-1]
          

        for index in range(n-2,-1,-1):
                curr  = [[0]*(m+1) for _ in range(3) ]
                for cap in range(1,capp+1):

                    curr[HOLD][cap] =  max(-prices[index] + next[BUY][cap], # buy
                                    0 + next[HOLD][cap], # skip 
                                    prices[index] + next[SELL][cap]) # sell
                    
                    curr[BUY][cap] = max(prices[index] + next[HOLD][cap -1], # sell
                                    0 + next[BUY][cap]) # hold
                    
                    curr[SELL][cap] = max(-prices[index] + next[HOLD][cap -1], # buy
                                    0 + next[SELL][cap]) # hold
                    
                next = curr
                        
      
        return next[HOLD][capp]