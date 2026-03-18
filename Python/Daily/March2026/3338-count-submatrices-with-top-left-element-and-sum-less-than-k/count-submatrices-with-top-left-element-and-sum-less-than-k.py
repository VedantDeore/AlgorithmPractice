class Solution:

    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        n = len(grid)
        m = len(grid[0])

        for i in range(n):
            for j in range(1,m):
                grid[i][j] += grid[i][j-1]
        
        for i in range(1,n):
            for j in range(m):
                grid[i][j] += grid[i-1][j]
            
        
        cnt=0

        for i in range(n):
            for j in range(m):
                # print(grid[i][j], end = "")
                if grid[i][j] <= k:
                    cnt += 1
                else:
                    break
            # print()


        return cnt
        
            