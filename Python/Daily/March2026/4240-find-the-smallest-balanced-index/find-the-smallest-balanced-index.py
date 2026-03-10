class Solution:
    def smallestBalancedIndex(self, nums: list[int]) -> int:
        lSum=0
        rProd=1

        ans = -1

        for i in range(len(nums)):
            lSum += nums[i]
        
        for i in range(len(nums)-1,-1,-1):
            lSum -= nums[i]

            if lSum == rProd:
                ans = i
                return ans
                break

            rProd = rProd*nums[i]

            if rProd > lSum:
                break
            
            
            # print(i, " " , lSum , " " , rProd )

            
        
        return ans
