class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        summ = list(matrix[0])
        maxVal = 0 
        
        desc = sorted(summ ,  reverse = True)

        for i in range(m):
            maxVal = max(maxVal, desc[i]*(i+1))

        for i in range(1,n):
            for j in range(m):
                if matrix[i][j] == 1:
                    summ[j] += 1
                else:
                    summ[j] = 0

            desc = sorted(summ, reverse = True)

            # print(desc)

            for k in range(m):
                maxVal = max(maxVal, desc[k]*(k+1))


        return maxVal
            
            
        

        