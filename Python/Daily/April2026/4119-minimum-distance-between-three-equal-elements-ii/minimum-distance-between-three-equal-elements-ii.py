class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        d = defaultdict(list)
        ans= float('inf')
        n= len(nums)
        for i in range(n):
            d[nums[i]].append(i)
            if len(d[nums[i]]) >=3:
                ans = min(ans, 2*(d[nums[i]][-1] - d[nums[i]][-3] ))

        return ans if ans!= float('inf') else -1