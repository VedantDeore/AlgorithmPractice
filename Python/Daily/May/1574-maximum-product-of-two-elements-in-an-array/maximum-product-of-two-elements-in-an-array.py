class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        nums = sorted(nums)
        a,b = nums[-1],nums[-2]
        return (a-1)*(b-1)