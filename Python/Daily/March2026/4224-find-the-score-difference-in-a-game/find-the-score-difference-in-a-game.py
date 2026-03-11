class Solution:
    def scoreDifference(self, nums: List[int]) -> int:

        first=0
        second=0
        firstactive=True
        secondactive=False

        for i in range(len(nums)):
            if nums[i] %2 == 1 :
                firstactive ,secondactive = secondactive,firstactive
            
            if (i+1)%6 == 0:
                firstactive ,secondactive = secondactive,firstactive
            
            if firstactive:
                first+=nums[i]

            if secondactive:
                second += nums[i]


        # print(first, " ", second)
        return first-second
        