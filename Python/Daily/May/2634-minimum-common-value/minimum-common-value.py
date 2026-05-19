class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        s1 = 0
        s2=0
        n1 = len(nums1)
        n2 = len(nums2)
        ans = -1
        while s1< n1 and s2<n2:
            if nums1[s1] == nums2[s2]:
                ans = nums1[s1]
                return ans
            elif nums1[s1] < nums2[s2]:
                s1+=1
            else:
                s2+=1
        
        return ans
        