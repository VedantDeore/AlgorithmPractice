class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        MOD = 10**9 + 7
        for query in queries:
            idx = query[0]
            while idx <= query[1]:
                nums[idx] = (nums[idx]*query[3])%MOD
                idx+=query[2]

        ans=0
        for i in nums:
            ans = ans^i

        return ans