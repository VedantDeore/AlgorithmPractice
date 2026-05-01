class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        n = len(nums)
        pre= [-1]*n
        minn = float('inf')
        for i in range(n-1,-1,-1):
            minn = min(minn, nums[i])
            pre[i] = minn


        ans=float('inf')
        ind = -1
        maxx = nums[0]
        for i in range(n):
            maxx = max(maxx, nums[i])
            iss = maxx - pre[i]
            if iss <= k:
                return i

        return -1