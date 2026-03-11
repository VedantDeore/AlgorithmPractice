class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n==0:
            return 1

        ans = 0
        i=0
        while n>0:
            bit = n & 1
            flipped = 1-bit
            ans += (2**i * flipped)
            i+=1
            n=n>>1

        return ans

