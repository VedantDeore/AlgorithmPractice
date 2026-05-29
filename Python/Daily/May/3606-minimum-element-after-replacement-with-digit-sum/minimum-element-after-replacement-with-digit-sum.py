class Solution:
    def summ(self, x):
        ans = 0
        while x>0:
            digit = x%10
            ans += digit
            x = x//10

        # print(ans)
        return ans
    def minElement(self, nums: List[int]) -> int:
        n = len(nums)
        ans = float('inf')
        for i in range(n):
            ans  = min(ans , self.summ(nums[i]))
        
        return ans
        