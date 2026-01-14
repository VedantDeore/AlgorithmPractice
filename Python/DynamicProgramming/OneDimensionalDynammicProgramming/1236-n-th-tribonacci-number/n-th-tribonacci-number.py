class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 1
        prev2 =0
        prev1 = 1
        prev = 1
        curr=0
        for i in range(3, n+1):
            curr = prev + prev1 + prev2
            prev2,prev1,prev = prev1, prev,curr 
        
        return curr


        
        