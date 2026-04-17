class Solution:
    def minMirrorPairDistance(self, nums: List[int]) -> int:
        # pairs=[]
        n = len(nums)
        rev={}
        ans = float('inf')
        for i in range(n):
            if nums[i] in rev:
                # pairs.append((i, rev[nums[i]]))
                ans = min(ans, abs(i  - rev[nums[i]]))
            rev[int(str(nums[i])[::-1])] = i
        
        # ans=float('inf')
        # for pair in pairs:
        #     ans = min(ans, abs(pair[0] - pair[1]))

        return ans if ans != float('inf')else -1