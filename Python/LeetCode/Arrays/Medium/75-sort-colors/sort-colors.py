class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        c0 = nums.count(0)
        c1 = nums.count(1)
        c2 = nums.count(2)
        i =0
        while(c0>0):
            nums[i] = 0
            c0 = c0-1
            i=i+1
        while(c1>0):
            nums[i] = 1
            c1 = c1-1
            i=i+1
        while(c2>0):
            nums[i] = 2
            c2=c2-1
            i=i+1
        return nums