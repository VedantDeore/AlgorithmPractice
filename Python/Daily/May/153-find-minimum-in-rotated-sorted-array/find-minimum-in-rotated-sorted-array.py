class Solution:
    def findMin(self, nums: List[int]) -> int:
        ans= float('inf')
        low=0
        high= len(nums)-1

        while low<=high:
            mid = low + (high - low )//2 
            ans = min(ans, nums[mid])
            if nums[low] < nums[mid] and nums[mid] < nums[high]:
                high = mid-1
            elif nums[low] > nums[mid] and nums[mid] < nums[high]:
                low = low+1
            else:
                low = low + 1
        
        return ans