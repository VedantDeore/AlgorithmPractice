class Solution:
    def isGood(self, nums: List[int]) -> bool:
        n= len(nums)
        base = list(range(1,n))+ [n-1]
        
        return sorted(nums) == base