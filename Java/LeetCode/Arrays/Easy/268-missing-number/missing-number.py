class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        sum = (n*(n+1)>>1)
        ans = 0
        for num in nums:
            ans = ans+num
        return sum-ans