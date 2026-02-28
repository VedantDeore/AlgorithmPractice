class Solution:
    def concatenatedBinary(self, n: int) -> int:
        ans=0
        length=0
        MOD = 10**9 + 7
        for i in range(1,n+1):
            if i & (i-1) == 0:
                length +=1
            
            ans = ((ans << length) | i)%MOD

        return ans