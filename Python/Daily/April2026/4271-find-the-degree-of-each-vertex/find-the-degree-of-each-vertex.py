class Solution:
    def findDegrees(self, matrix: list[list[int]]) -> list[int]:
        n = len(matrix)
        ans =[]
        for i in range(n):
            cnt=0
            for j in range(n):
                if matrix[i][j] ==1:
                    cnt+=1
            ans.append(cnt)

        return ans