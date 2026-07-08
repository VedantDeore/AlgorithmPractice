class Solution:
    def maxDigitRange(self, nums: list[int]) -> int:
        ans = 0
        larg = 0
        for num in nums:
            mini = float('inf')
            maxi = float('-inf')
            numi=num
            while num:
                i = num%10
                num = num//10
                mini = min(i, mini)
                maxi = max(i, maxi)

            diff = maxi-mini
            # print(diff)
            # print(ans)
            # print('lar', larg, " maxi and mini", maxi, " ", mini)
            if diff > larg:
                larg = diff
                ans = numi
            elif diff == larg:
                ans += numi

        
        return ans

        