class Solution:
    def func(self, arr:List[int], goal:int)-> int:
        if goal <0:
            return 0

        l=0;r=0;sum_val=0;cnt=0
        while r< len(arr):
            sum_val += arr[r]

            while sum_val > goal:
                sum_val -= arr[l]
                l+=1

            cnt = cnt + (r-l+1)
            r+=1
        
        return cnt
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        return self.func(nums,goal) - self.func(nums,goal-1)

        