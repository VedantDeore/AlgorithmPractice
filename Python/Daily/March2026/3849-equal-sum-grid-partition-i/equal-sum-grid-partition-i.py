class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        n = len(grid)
        m = len(grid[0])

        totSum = 0
        rows = [0]*n
        cols = [0]*m

        for i in range(n):
            for j in range(m):
                totSum+= grid[i][j]
                rows[i] += grid[i][j]
                cols[j] += grid[i][j]

        
        upper = 0

        if totSum %2 != 0:
            return False

        for i in range(n):
            upper += rows[i]
            lower = totSum -upper

            if upper == lower:
                return True

        left = 0
        for j in range(m):
            left += cols[j]
            right = totSum - left

            if left == right:
                return True

        return False





        