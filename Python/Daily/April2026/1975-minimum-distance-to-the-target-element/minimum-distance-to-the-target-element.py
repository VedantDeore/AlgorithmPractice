class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        ans=float('inf')
        n = len(nums)
        for i in range(n):
            if nums[i] == target:
                ans = min(ans, abs(i-start))
        
        return ans
        