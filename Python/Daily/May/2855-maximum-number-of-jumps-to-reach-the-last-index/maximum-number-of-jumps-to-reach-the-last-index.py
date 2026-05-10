class Solution:
    def f(self, i, nums, target):
        if i ==0:
            return 0

        ans = float('-inf')
        for j in range(i):
            if abs(nums[j] - nums[i]) <= target:
                prev = 1 + self.f(j, nums, target)
                ans = max(prev, ans)

        return ans

    def fm(self, i, nums, target, dp):
        if i ==0:
            return 0

        if dp[i] != -1:
            return dp[i]

        ans = float('-inf')
        for j in range(i):
            if abs(nums[j] - nums[i]) <= target:
                prev = 1 + self.fm(j, nums, target, dp)
                ans = max(prev, ans)
        
        dp[i] = ans

        return dp[i]

        # return ans


    def ft(self, nums, target):
        n = len(nums)
        dp = [-1]*n
        dp[0] = 0
      


        for i in range(1, n):
            ans = float('-inf')
            for j in range(i):
                if abs(nums[j] - nums[i]) <= target:
                    prev = 1 + dp[j]
                    ans = max(prev, ans)
        
            dp[i] = ans

        return dp[n-1]


    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n==2:
            return 1 if abs(nums[1] - nums[0]) <= target else -1
  

        # dp = [0]*n

        # for i in range(n):
        #     for j in range(0, i):
        #         dp[i] = max(dp[j], dp[i] +1) if abs(nums[j] - nums[i]) <= target else dp[i-1]

        ans =  self.ft(nums, target)
        return ans if ans != float('-inf') else -1

        
        # return dp[n-1] 

        