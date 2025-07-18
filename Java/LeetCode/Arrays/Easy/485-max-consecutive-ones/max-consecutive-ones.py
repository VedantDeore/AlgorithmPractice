class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        count=0
        maxn=0
        for num in nums:
            if num==1:
                count=count+1
                maxn= max(maxn,count)
            else:
                count=0
        return maxn