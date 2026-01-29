class Pair:
    def __init__(self, row,col,dist):
        self.row = row
        self.col = col
        self.dist = dist

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])

        distance : List[List[int]] = [[0]*(m) for _ in range(n)]
        visited : List[List[int]] = [[0]*(m) for _ in range(n)]

        q = deque()
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    q.append(Pair(i,j,0))
                    visited[i][j] = 1
                else:
                    visited[i][j] = 0

        delRow = [-1,0,1,0]
        delCol = [0,1,0,-1]
        while q:
            row = q[0].row
            col = q[0].col
            dist = q[0].dist
            
            distance[row][col] = dist
            q.popleft()

            for i in range(4):
                n_row = row + delRow[i]
                n_col = col + delCol[i]

                if(n_row >=0 and n_row<n and n_col >=0 and n_col < m):
                    if( visited[n_row][n_col] == 0 and mat[n_row][n_col] == 1):
                        visited[n_row][n_col] = 1
                        q.append(Pair(n_row,n_col, dist+1))
            
        return distance