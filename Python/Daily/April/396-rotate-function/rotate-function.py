class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)
        F0= 0
        for i in range(n):
            F0 += nums[i]*i

        ans = F0
        Fprev = F0
        summ = sum(nums)
        for i in range(1, n+1):
            Fi = Fprev + summ - n*(nums[n-i])
            ans = max(ans, Fi)
            Fprev = Fi

        return ans
