class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i=0
        n=len(nums)
        for num in nums:
            if num!=0:
                nums[i] = num
                i=i+1
        while i<n:
            nums[i] =0
            i=i+1
        