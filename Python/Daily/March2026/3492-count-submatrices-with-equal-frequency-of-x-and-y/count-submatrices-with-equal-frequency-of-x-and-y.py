class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        ans = 0
        prefX = [[0] * m for _ in range(n)]
        prefY = [[0] * m for _ in range(n)]

        for i in range(n):
            for j in range(m):
    
                curX = 1 if grid[i][j] == 'X' else 0
                curY = 1 if grid[i][j] == 'Y' else 0
                topX = prefX[i-1][j] if i > 0 else 0
                leftX = prefX[i][j-1] if j > 0 else 0          
                topY = prefY[i-1][j] if i > 0 else 0
                leftY = prefY[i][j-1] if j > 0 else 0             
                diagX = prefX[i-1][j-1] if (i > 0 and j > 0) else 0
                diagY = prefY[i-1][j-1] if (i > 0 and j > 0) else 0    
                prefX[i][j] = curX + topX + leftX - diagX
                prefY[i][j] = curY + topY + leftY - diagY

                if prefX[i][j] > 0 and prefX[i][j] == prefY[i][j]:
                    ans += 1

        return ans