class Solution:
    def dfs(self, i,j, grid, direc, visited):
        n = len(grid)
        m = len(grid[0])
        if i==n-1 and j == m-1:
            return True

        visited[i][j] = True

        for dire in direc[grid[i][j]]:
            nr = i + dire[0]
            nc = j + dire[1]

            if nr < 0 or nr >=n or nc <0 or nc>=m or visited[nr][nc]:
                continue
            for auto in direc[grid[nr][nc]]:
                if nr + auto[0] == i and nc + auto[1] == j:
                    if self.dfs(nr, nc, grid, direc, visited):
                        return True

        return False


    def hasValidPath(self, grid: List[List[int]]) -> bool:
        n = len(grid)
        m = len(grid[0])
        visited = [[False]*m for _ in range(n)]

        direc = {
            1: [(0, -1), (0, 1)],  # Left, Right
            2: [(-1, 0), (1, 0)],  # Up, Down
            3: [(0, -1), (1, 0)],  # Left, Down
            4: [(0, 1), (1, 0)],   # Right, Down
            5: [(0, -1), (-1, 0)], # Left, Up
            6: [(0, 1), (-1, 0)]    # Right, Up
        }

        return self.dfs(0,0,grid,direc,visited)