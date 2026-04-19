class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        ans = float('-inf')
        
        i=0
        j=0
        n = len(nums1)
        m = len(nums2)
        while i<n and j<m:
            if nums1[i] <= nums2[j] and i<=j:
                ans= max(ans, j-i)
                j+=1
            elif j<i:
                i+=1
            else:
                j+=1
                i+=1
        
        return ans if ans != float('-inf')else 0

            
        