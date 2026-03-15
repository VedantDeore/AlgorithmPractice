class Solution:
    def countCommas(self, n: int) -> int:
        if n<=999:
            return 0

        div = 1000
        ans=0
        while n>= div:
            ans += (n - div +1)
            div = div*1000


        return ans
        