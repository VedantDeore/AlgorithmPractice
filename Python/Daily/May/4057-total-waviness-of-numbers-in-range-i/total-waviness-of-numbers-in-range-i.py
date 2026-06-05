class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        cnt=0
        for num in range(num1, num2+1):
            nums = str(num)
            for j in range(1,len(nums)-1):
                if nums[j-1] < nums[j] and nums[j] > nums[j+1]:
                    cnt+=1
                if nums[j-1] > nums[j] and nums[j] < nums[j+1]:
                    cnt+=1

        return cnt
        