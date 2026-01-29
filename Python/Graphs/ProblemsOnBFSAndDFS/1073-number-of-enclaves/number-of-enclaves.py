class Pair:
        def __init__(self, first: int, second: int):
            self.first = first
            self.second = second
class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
            
        visited = [[False] * n for _ in range(m)]
            
        delRow = [-1, 0, 1, 0]
        delCol = [0, 1, 0, -1]
            
        q = deque()
            # corner row, col
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and (i == 0 or j == 0 or i == m - 1 or j == n - 1):
                    q.append(Pair(i, j))
                    visited[i][j] = True
            
        while q:
            row = q[0].first
            col = q[0].second
            q.popleft()
                
            for i in range(4):
                nrow = row + delRow[i]
                ncol = col + delCol[i]
                if nrow >= 0 and nrow < m and ncol >= 0 and ncol < n and not visited[nrow][ncol] and grid[nrow][ncol] == 1:
                    visited[nrow][ncol] = True
                    q.append(Pair(nrow, ncol))
            
        cnt = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == 1:
                    cnt += 1
        return cnt