class Solution:
    def sumAndMultiply(self, n: int) -> int:
        ans = 0
        summ=0
        p=1
        while n:
            digit = n%10
            if digit != 0:
                ans = ans + digit*p
                p=p*10
            summ += digit
            n = n//10

        return ans*summ