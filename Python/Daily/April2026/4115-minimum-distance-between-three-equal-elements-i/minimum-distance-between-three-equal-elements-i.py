class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        ans= 1000
        n = len(nums)
        for i in range(n):
            for j in range(i+1,n):
                for k in range(j+1,n):
                    if nums[i] == nums[j] == nums[k]:
                        ans = min(ans, abs(i-j) + abs(j-k) + abs(k-i))

        return ans if ans!= 1000 else -1
        