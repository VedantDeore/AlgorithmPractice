class Solution:
    def rotate(self, mat, target,n):
        for i in range(n):
            for j in range(i,n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

        
    
        for i in range(n):
            for j in range(n // 2):
                mat[i][j], mat[i][n-1-j] = mat[i][n-1-j], mat[i][j]

        return mat==target
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        n = len(mat)

        for cnt in range(4):
            if self.rotate(mat,target,n):
                return True

        
        return False
        

    
    
