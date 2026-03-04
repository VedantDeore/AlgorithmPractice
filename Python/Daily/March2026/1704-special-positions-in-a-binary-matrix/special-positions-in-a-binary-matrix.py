class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        m = len(mat)
        n = len(mat[0])
        row = [0]*m
        col = [0]*n
        i=0


        for i in range(m):
            for j in range(n):
                row[i] += mat[i][j]
                col[j] += mat[i][j]
                
        print(row)
        print(col)
        cnt=0
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1 and row[i] == col[j] == 1:
                    cnt+=1
                else:
                    continue

        return cnt

        # [[0,0,0,0,0,1,0,0], 1
        #  [0,0,0,0,1,0,0,1], 2
        #  [0,0,0,0,1,0,0,0], 1
        #  [1,0,0,0,1,0,0,0], 2
        #  [0,0,1,1,0,0,0,0]] 2
        #   1 0 1 1 3 1 0 1 