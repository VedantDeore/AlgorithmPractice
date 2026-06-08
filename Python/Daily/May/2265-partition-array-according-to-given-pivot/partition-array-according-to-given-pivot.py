class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        left = []
        right = []
        n = len(nums)
        cnt=0
        for i in range(n):
            if nums[i] < pivot:
                left.append(nums[i])
            elif nums[i] > pivot:
                right.append(nums[i])
            else:
                cnt+=1
                continue
            
        left.extend([pivot]*cnt)
        left.extend(right)

        return left

        