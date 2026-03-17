import heapq

class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])

        top_sums = set()

        def add_val(val):
            top_sums.add(val)

        def findSum(r, c, s):
            summ = 0
            for i in range(s):
                summ += grid[r - s + i][c + i]     # Top to Right
                summ += grid[r + i][c + s - i]     # Right to Bottom
                summ += grid[r + s - i][c - i]     # Bottom to Left
                summ += grid[r - i][c - s + i]     # Left to Top
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