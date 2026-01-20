class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        INF = 10**9
        target = amount
        prev = [0]*(target+1)
          
        for T in range(target+1):
            if(T % coins[0] == 0):
                prev[T] = T//coins[0]
            else:
                prev[T] =  INF
        
 
        
        for ind in range(1,len(coins)):
            curr = [0]*(target+1)
            for T in range(target +1):
                not_take = 0 + prev[T]
                take = INF
                
                if coins[ind] <= T :
                    take = 1 + curr[T- coins[ind]]

                curr[T] = min(take, not_take)
            prev = curr
        return prev[target] if (prev[target] != INF) else -1