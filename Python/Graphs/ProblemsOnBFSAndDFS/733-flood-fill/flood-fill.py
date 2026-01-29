class Solution:
    def dfs(self, row : int, col: int ,initial_color:int, new_color: int, ans: List[List[int]], delRow:List[int], delCol: List[int]):
        ans[row][col] = new_color
        n = len(ans)
        m = len(ans[0])

        for i in range(4):
            n_row = row + delRow[i]
            n_col = col + delCol[i]

            if(n_row >= 0 and n_row < n and n_col >=0 and n_col <m):
                if(ans[n_row][n_col] == initial_color and ans[n_row][n_col] != new_color):
                    self.dfs(n_row,n_col, initial_color, new_color, ans,delRow, delCol)
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        initialColor = image[sr][sc]
        ans = image
        delRow = [-1,0,1,0]
        delCol = [0,1,0,-1]
        self.dfs(sr,sc,initialColor, color,ans,delRow,delCol)
        return ans

