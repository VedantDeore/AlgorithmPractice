class Solution:
    neg_inf = float('-inf')
    def f(self, i, j, grid, both, dp):
        if i == 0 and j == 0:
            return [grid[0][0], grid[0][0]]

        if i < 0 or j < 0:
            return [self.neg_inf, self.neg_inf]

        if dp[i][j] is not None:
            return dp[i][j]

        res_up = self.f(i-1, j, grid, both, dp)
        res_left = self.f(i, j-1, grid, both, dp)
        
        up = list(res_up)
        left = list(res_left)

        if up[0] != self.neg_inf:
            up[0] = grid[i][j] * up[0]
        if up[1] != self.neg_inf:
            up[1] = grid[i][j] * up[1]

        if left[0] != self.neg_inf:
            left[0] = grid[i][j] * left[0]
        if left[1] != self.neg_inf:
            left[1] = grid[i][j] * left[1]

        # YOUR LOGIC: current cell stores [max from up, max from left]
        # Note: To pass all cases, you'll eventually need min() here too!
        dp[i][j] = [max(up), max(left)]
        return dp[i][j]

    def ft(self, grid,n,m):
        dp = [[None for _ in range(m)] for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    dp[i][j] =  [grid[0][0], grid[0][0]]
                else:
                    res_up = [self.neg_inf, self.neg_inf]
                    res_left = [self.neg_inf, self.neg_inf]
                    if i > 0:
                        res_up = dp[i-1][j]
                    if j>0:
                        res_left = dp[i][j-1]
                    
                    up = list(res_up)
                    left = list(res_left)

                    if up[0] != self.neg_inf:
                        up[0] = grid[i][j] * up[0]
                    if up[1] != self.neg_inf:
                        up[1] = grid[i][j] * up[1]

                    if left[0] != self.neg_inf:
                        left[0] = grid[i][j] * left[0]
                    if left[1] != self.neg_inf:
                        left[1] = grid[i][j] * left[1]

                    all_results = [up[0], up[1], left[0], left[1]]

                    current_max = self.neg_inf
                    current_min = float('inf')

                    for val in all_results:
                        if val != self.neg_inf:
                            if val > current_max:
                                current_max = val
                            if val < current_min:
                                current_min = val

                    dp[i][j] = [current_max, current_min]
        
        return dp[i][j]
    def maxProductPath(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        
        # FIX: Initialize as 2D None so "is not None" works correctly
        dp = [[None for _ in range(m)] for _ in range(n)]

        both = [0]*2
        # ans = self.f(n-1, m-1, grid, both, dp)
        ans = self.ft(grid,n,m)
        res = max(ans)
        return res % (10**9 + 7) if res >= 0 else -1