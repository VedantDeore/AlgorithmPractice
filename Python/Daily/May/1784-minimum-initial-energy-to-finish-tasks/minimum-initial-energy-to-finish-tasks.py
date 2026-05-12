class Solution:
    def isPossible(self, tasks, mid):
        arr = sorted(tasks, key = lambda  x : x[0] - x[1])
        # print(arr)

        for actual, minimum in arr:
            if minimum > mid:
                return False
            
            mid = mid - actual

        return True

    def minimumEffort(self, tasks: List[List[int]]) -> int:
        low = 0
        high = 10**9

        ans = float('inf')

        while low<=high:
            mid = low + (high-low)//2

            if self.isPossible(tasks, mid):
                ans = mid
                high = mid-1
            else:
                low = mid+1

        return ans