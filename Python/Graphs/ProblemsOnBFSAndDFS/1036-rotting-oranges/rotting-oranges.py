class Pair:
    def __init__(self, row:int, col:int,time:int):
        self.row = row
        self.col = col
        self.time = time

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        m = len(grid[0])
        q = deque()

        fresh_count = 0        
        for row in range(n):
            for col in range(m):
                if grid[row][col] == 2:
                    q.append(Pair(row,col,0))
                if grid[row][col] == 1:
                    fresh_count+=1

        delRow = [-1,0,1,0]
        delCol = [0,1,0,-1]

        q_cnt=0
        timing=0
        while q:
            row = q[0].row
            col = q[0].col
            time = q[0].time
            timing= max(timing,time)
            q.popleft()
            for i in range(4):
                n_row = row + delRow[i]
                n_col = col + delCol[i]

                if(n_row >= 0 and n_row < n and n_col >=0 and n_col <m):
                    if(grid[n_row][n_col] == 1):
                        q_cnt+=1
                        grid[n_row][n_col] = 2
                        q.append(Pair(n_row,n_col,time+1))
        
        if q_cnt == fresh_count:
            return timing
        else:
            return -1