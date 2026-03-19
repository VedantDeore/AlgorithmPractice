class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])

        ans = 0

        mat = [[0]*m for _ in range(n)]
        hasX = [[0]*m for _ in range(n)]
       
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 'X':
                    mat[i][j] = 1
                    hasX[i][j] +=1
                elif grid[i][j] == 'Y':
                    mat[i][j] = -1
                else:
                    mat[i][j] = 0

        for i in range(n):
            for j in range(1,m):
                mat[i][j] += mat[i][j-1]
                hasX[i][j] += hasX[i][j-1]
        
        for i in range(1,n):
            for j in range(m):
                mat[i][j] += mat[i-1][j]
                hasX[i][j] += hasX[i-1][j]


        
        # for row in mat:
        #     print(row)
            
        # for row in hasX:
        #     print(row)


        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0 and hasX[i][j] >= 1:
                    ans+=1

        return ans

                    
            
                
