class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        
        n = len(nums)
        maxcnt=0
        for i in range(n):
            odd = set()
            even = set()
    
            for j in range(i,n):
                if nums[j] &1 == 0:
                    even.add(nums[j])
                else:
                    odd.add(nums[j])

                if len(even) == len(odd):
                    maxcnt = max(maxcnt, j-i+1)         

        return maxcnt