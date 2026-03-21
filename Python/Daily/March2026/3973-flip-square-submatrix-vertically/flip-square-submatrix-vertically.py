class Solution:
    # def reverse(self, mat, st, end):
    #     return mat[::-1]
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:
        
        n = len(grid)
        m = len(grid[0])

        submat= []


        for i in range(x,x+k):
            row = []
            for j in range(y,y+k):
                row.append(grid[i][j])

            # print(row)            
            submat.append(row)


        submat =  submat[::-1]

        ii=0
        for i in range(x,x+k):
            jj=0
            for j in range(y,y+k):
                grid[i][j] = submat[ii][jj]
                jj+=1
            ii+=1

        return grid
