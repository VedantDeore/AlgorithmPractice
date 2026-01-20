class Solution:
    def count_partitions(self, arr, d):
        total_sum = sum(arr)



        if abs(d) > total_sum:
            return 0
        if (total_sum - d) % 2 != 0:
            return 0



        target = (total_sum - d) // 2
        return self.f_space_optimisation(arr, target)

    def f_space_optimisation(self, arr, k):
        prev = [0] * (k + 1)
        prev[0] = 1



        for num in arr:
            curr = [0] * (k + 1)
            for t in range(k + 1):
                curr[t] = prev[t]
                if t >= num:
                    curr[t] += prev[t - num]
            prev = curr


        return prev[k]

    def findTargetSumWays(self, nums: List[int], target: int) -> int:

        
        return self.count_partitions(nums, target)