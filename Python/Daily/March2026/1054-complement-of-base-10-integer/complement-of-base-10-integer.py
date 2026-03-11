class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n==0:
            return 1

        mask=0
        x = n
        while x>0:
            mask = (mask <<1) |1
            x = x>>1

        return mask^n

