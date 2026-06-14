class Solution:
    def checkGoodInteger(self, n: int) -> bool:
        sq =0 
        s= 0
        while n>0:
            digit = n%10
            sq += digit*digit 
            s += digit
            n = n//10

        return True if sq - s >= 50 else False