class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        a = max(nums)
        b = min(nums)
        return abs(a-b)*k
        