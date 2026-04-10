class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        ans= 1000
        n = len(nums)
        d = defaultdict(list)
        for i in range(n):
            d[nums[i]].append(i)

            if len(d[nums[i]]) >= 3:
                ans = min(ans, 2*(d[nums[i]][-1] - d[nums[i]][-3]) )
        
        # print(d)
        # return ans if ans!= 1000 else -1
        

        return ans if ans!= 1000 else -1
        