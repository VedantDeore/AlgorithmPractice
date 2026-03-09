class Solution:
    def solve(self, zero, one, limit ,dp):
        M = 10**9 + 7

        dp[0][0][0] = 1
        dp[0][0][1] = 1

        for zeroleft in range(0, zero+1):
            for oneleft in range(0, one+1):
                if zeroleft ==0 and oneleft ==0:
                    continue
                for lastwasone in range(2):
        
                    result = 0
                    if lastwasone == 1:
                        for i in range(1, min(limit, zeroleft) + 1):
                            result += dp[zeroleft- i][oneleft][0]%M
                    else:   
                        for i in range(1, min(limit, oneleft) + 1):
                            result += dp[zeroleft][oneleft - i][1]%M

                    dp[zeroleft][oneleft][lastwasone] = result


       
        return (dp[zero][one][0] + dp[zero][one][1]) % M

    # def solve(self, zeroleft, oneleft, lastwasone, limit ,dp):
    #     if (oneleft == 0 and zeroleft ==0):
    #         return 1

    #     if dp[zeroleft][oneleft][lastwasone] != -1 :
    #         return  dp[zeroleft][oneleft][lastwasone]

        

    #     result = 0
    #     if lastwasone:
    #         for i in range(1, min(limit, zeroleft) + 1):
    #             result += self.solve(zeroleft- i, oneleft, False, limit,dp)
    #     else:   
    #         for i in range(1, min(limit, oneleft) + 1):
    #             result += self.solve(zeroleft, oneleft - i , True, limit,dp)

    #     dp[zeroleft][oneleft][lastwasone]  = result
    #     return result

    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:

        dp = [[[-1]*2 for i in range(201)] for i in range(201)]

        # start_with_1 = self.solve(zero, one, False, limit, dp)
        # start_with_0 = self.solve(zero, one, True, limit, dp)

        # return int((start_with_1 + start_with_0)%M)

        return self.solve(zero,one, limit, dp)
    

        