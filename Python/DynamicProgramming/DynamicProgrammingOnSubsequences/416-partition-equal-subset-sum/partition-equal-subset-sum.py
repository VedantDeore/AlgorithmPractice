class Solution:
    def f_space_optimisation(self, arr,k):
        n = len(arr)
        prev = [False]*(k+1)
        curr = [False]*(k+1)

        prev[0] = True
        curr[0] = True

        if arr[0] <=k:
            prev[arr[0]] = True
        
        for ind in range(1,n):
            curr = [False]*(k+1)
            curr[0] =True
            for target in range(1,k+1):
                not_take = prev[target]
                take = False

                if target >= arr[ind]:
                    take = prev[target -arr[ind]]

                curr[target] = take or not_take

            prev = curr

        return prev[k]
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        sum =0
        for i in range(n):
            sum += nums[i]

        if sum%2== 0:
            return self.f_space_optimisation(nums, sum//2)
        else:
            return False
        