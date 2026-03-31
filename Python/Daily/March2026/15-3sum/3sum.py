class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        # ans :List[List[int]] = []
        nums= sorted(nums)
        s : Set[Tuple(int,int,int)]= set()
        for i in range(n):
            if i>0 and nums[i] == nums[i-1]:
                continue
            
            j=i+1
            k=n-1
            while j<k:
                if nums[i] + nums[j] + nums[k] == 0:
                    # print("yes")
                    s.add((nums[i], nums[j], nums[k]))
                    j+=1
                    k-=1
                    while j<k and nums[j]==nums[j-1]: j+=1
                    while j<k and nums[k]==nums[k+1]: k-=1
                elif nums[i] + nums[j] + nums[k] <0:                  
                    j+=1
                else:
                    k-=1
                
            
        
        return list(s)

        