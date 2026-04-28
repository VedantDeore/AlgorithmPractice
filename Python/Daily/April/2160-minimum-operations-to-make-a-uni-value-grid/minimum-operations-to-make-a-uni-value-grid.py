import statistics
class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        n = len(grid)
        m = len(grid[0])

        arr =[]
        p = grid[0][0]%x
        for i in range(n):
            for j in range(m):
                if grid[i][j] % x != p:
                    return -1
                arr.append(grid[i][j]//x)
                
        arr = sorted(arr)
        median = int(statistics.median(arr))

        ans = 0
        for i in range(len(arr)):
            ans += abs(arr[i] - median)

        return ans

        
        