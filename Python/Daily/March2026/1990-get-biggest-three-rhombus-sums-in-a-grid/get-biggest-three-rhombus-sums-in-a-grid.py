import heapq

class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])

        top_sums = set()

        def add_val(val):
            top_sums.add(val)

        
        d1 = [[0]*n for _ in range(m)]
        d2 = [[0]*n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                d1[i][j] = grid[i][j]

                if i-1>=0 and j-1>=0:
                    d1[i][j] += d1[i-1][j-1]

        for i in range(m):
            for j in range(n):
                d2[i][j] = grid[i][j]

                if i-1>=0 and j+1<n:
                    d2[i][j] += d2[i-1][j+1]


        def findSum(r, c, sidei):
            summ = 0
            # for i in range(s):
            #     summ += grid[r - s + i][c + i]     # Top to Right
            #     summ += grid[r + i][c + s - i]     # Right to Bottom
            #     summ += grid[r + s - i][c - i]     # Bottom to Left
            #     summ += grid[r - i][c - s + i]     # Left to Top


            top_r,top_c = r-side, c
            right_r,right_c = r, c+side
            left_r,left_c = r, c-side
            down_r,down_c = r+side, c


            summ += d1[right_r][right_c] - (d1[top_r-1][top_c-1]  if top_r-1>=0 and top_c-1>=0 else 0 )
                
            
            summ += d1[down_r][down_c] -( d1[left_r-1][left_c-1] if left_r-1>=0 and left_c-1>=0 else 0   )

           
            summ += d2[left_r][left_c] - (d2[top_r-1][top_c+1] if top_r-1>=0 and top_c+1 < n else 0)

            
            summ += d2[down_r][down_c] - ( d2[right_r-1][right_c+1 ] if right_r-1>=0 and right_c+1 < n else 0)

            summ -= (grid[top_r][top_c] + grid[down_r][down_c] + grid[left_r][left_c] + grid[right_r][right_c])


            return summ

        for r in range(m):
            for c in range(n):

                # for 0 side rhombus 
                add_val(grid[r][c])
                
                maxrng = min(m,n)
                for side in range(1,maxrng):
                    if (r+side <m and r-side>=0 and c+side<n and c-side>=0):
                        summ = findSum(r,c,side) 
                        add_val(summ)


        return list(heapq.nlargest(3, top_sums))