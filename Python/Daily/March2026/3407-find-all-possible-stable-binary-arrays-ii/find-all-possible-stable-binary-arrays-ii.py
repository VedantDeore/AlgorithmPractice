class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        M = 10**9 + 7
        t = [[[0]*2 for i in range(one+1)] for i in range(zero+1)]

        t[0][0][0] = 1
        t[0][0][1] = 1

        for i in range(1, min(zero, limit)+1):
            t[i][0][0] = 1

        for j in range(1, min(one, limit)+1):
            t[0][j][1] = 1


        for i in range(0,zero+1):
            for j in range(0,one+1):

                if i==0 or j==0:
                    continue

                t[i][j][0] = (t[i-1][j][1] + t[i-1][j][0] - (t[i- limit - 1][j][1] if i > limit else 0) + M )%M

                t[i][j][1] = (t[i][j-1][0] + t[i][j-1][1] - (t[i][j-limit -1][0] if j > limit else 0) + M )%M



        return (t[zero][one][0] + t[zero][one][1] )%M