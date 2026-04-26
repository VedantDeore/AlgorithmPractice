class Solution:
    def checkk(self, i,j,grid, visited):
        n = len(grid)
        m = len(grid[0])
        
        q = deque()
        #child, parent
        q.append((i,j,-1,-1))

        visited[i][j] = True

        dr = [0,1,0,-1]
        dc = [1,0,-1,0]

        while q:
            r = q[0][0] 
            c = q[0][1]
            pr = q[0][2]
            pc = q[0][3]

            q.popleft()

            for ii in range(4):
                nr = r + dr[ii]
                nc = c + dc[ii]

                if nr >=0 and nr<n and nc>=0 and nc<m:
                    if grid[nr][nc] == grid[r][c]:
                        if not visited[nr][nc] :
                            q.append((nr,nc,r,c))
                            visited[nr][nc] = True     
                        elif (nr, nc) != (pr,pc):
                            return True
            
                

        return False



    def containsCycle(self, grid: List[List[str]]) -> bool:
        n = len(grid)
        m = len(grid[0])
        visited = [[False]*m for _ in range(n)]

        # parents = [ [-1]*m for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if not visited[i][j]:
                    # visited[i][j] = True
                    if self.checkk(i,j,grid, visited) == True:
                        return True

        return False
                    