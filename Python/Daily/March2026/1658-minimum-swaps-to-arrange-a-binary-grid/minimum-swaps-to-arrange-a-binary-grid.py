class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        trailing =[]
        for row in grid:
            count=0
            for j in range(len(row)-1,-1,-1):
                if row[j] == 0:
                    count+=1
                else:
                    break

            trailing.append(count)                
        
        # print(trailing)
        swaps = 0
        n = len(trailing)
        for i in range(0,n):
            needed = n-1-i

            if trailing[i] >= needed:
                continue
            
            j=i+1

            while j< n  and trailing[j] < needed:
                j+=1

            if j==n:
                return -1

            while j>i:
                temp = trailing[j]
                trailing[j] = trailing[j-1]
                trailing[j-1] = temp
                swaps+=1
                j-=1

        return swaps
            
        
             

