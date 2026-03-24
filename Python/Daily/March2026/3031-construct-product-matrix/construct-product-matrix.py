class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        m = len(grid[0])

        # prefix = [[1]*m for _ in range(n)]
        suffix = [[1]*m for _ in range(n)]

        p=1
        s=1
        # for i in range(n):
        #     for j in range(m):
        #         prefix[i][j] = p
        #         p = p*grid[i][j]
        
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                suffix[i][j] = s
                s = (s*grid[i][j]) % 12345

            
        for i in range(n):
            for j in range(m):
                suffix[i][j] =(p*suffix[i][j])% 12345

                p = (p*grid[i][j])% 12345

        return suffix
        