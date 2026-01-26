class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total=0
        max_sum = min_sum = nums[0]
        cur_max = cur_min = 0

        for x in nums:
            cur_max = max(x, cur_max + x)
            max_sum = max(cur_max, max_sum)

            cur_min = min(x, cur_min + x)
            min_sum = min(cur_min, min_sum)

            total +=x

        if max_sum <0:
            return max_sum

        return max(max_sum, total - min_sum)



        