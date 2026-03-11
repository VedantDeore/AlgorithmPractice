class Solution:
    def fact(self, n):
        if n==0:
            return 1
        ans=1
        while n>=1:
            ans=  ans*n
            n-=1
        
        return ans
    def isDigitorialPermutation(self, n: int) -> bool:
        check=0
        dp=[-1]*10
        n2 = n
        while n>0:
            digit = n%10
            if dp[digit] == -1:
                dp[digit] = self.fact(digit)
            
            check = check + dp[digit]

            n=n//10
        
        # print(dp , " ", check)
        
        if (sorted(str(check)) == sorted(str(n2))):
            # print("yes")
            return True
        
        return False



        