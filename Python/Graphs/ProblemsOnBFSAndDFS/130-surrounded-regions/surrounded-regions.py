class Solution:
    def _dfs(self, row: int, col: int, board: List[List[str]], visited: List[List[bool]], delRow: List[int], delCol: List[int]) -> None:
            visited[row][col] = True
            
            for i in range(4):
                nrow = row + delRow[i]
                ncol = col + delCol[i]
                
                if nrow >= 0 and nrow < len(board) and ncol >= 0 and ncol < len(board[0]) and not visited[nrow][ncol] and board[nrow][ncol] == 'O':
                    self._dfs(nrow, ncol, board, visited, delRow, delCol)
        
    def solve(self, board: List[List[str]]) -> None:
            n = len(board)
            m = len(board[0])
            visited = [[False] * m for _ in range(n)]
            
            delRow = [-1, 0, 1, 0]
            delCol = [0, 1, 0, -1]
            # first and the last row
            for j in range(m):
                if not visited[0][j] and board[0][j] == 'O':
                    self._dfs(0, j, board, visited, delRow, delCol)
                
                if not visited[n - 1][j] and board[n - 1][j] == 'O':
                    self._dfs(n - 1, j, board, visited, delRow, delCol)
            
            # first and last col
            for i in range(n):
                if not visited[i][0] and board[i][0] == 'O':
                    self._dfs(i, 0, board, visited, delRow, delCol)
                
                if not visited[i][m - 1] and board[i][m - 1] == 'O':
                    self._dfs(i, m - 1, board, visited, delRow, delCol)
            
            for i in range(n):
                for j in range(m):
                    if not visited[i][j]:
                        board[i][j] = 'X'