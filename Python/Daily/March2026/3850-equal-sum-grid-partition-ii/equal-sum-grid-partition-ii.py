from typing import List

class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        total_sum = sum(sum(row) for row in grid)

        def check_horizontal(current_grid: List[List[int]]) -> bool:
            rows = len(current_grid)
            cols = len(current_grid[0])
            top_sum = 0
            seen_elements = set()

            # Iterate through possible cuts from row 0 up to rows - 2
            # (Ensures at least one row remains in the bottom section)
            for i in range(rows - 1):
                # Add current row's elements to the tracking set and sum
                for j in range(cols):
                    val = current_grid[i][j]
                    seen_elements.add(val)
                    top_sum += val
                
                bottom_sum = total_sum - top_sum
                diff = top_sum - bottom_sum

                # Case 1: Perfectly equal sums
                if diff == 0:
                    return True
                
                # Case 2: Check "Safe" cells for removal
                # Removing these cells is guaranteed not to break connectivity
                if diff == current_grid[0][0]:
                    return True
                if diff == current_grid[0][cols - 1]:
                    return True
                if diff == current_grid[i][0]:
                    return True
                if diff == current_grid[i][cols - 1]:
                    return True
                
                # Case 3: If section is 2D (i > 0 and cols > 1), 
                # any previously seen cell is safe to remove
                if i > 0 and cols > 1 and diff in seen_elements:
                    return True
            
            return False

        # 1. Check Horizontal Cuts (Top Section)
        if check_horizontal(grid):
            return True

        # 2. Check Horizontal Cuts (Bottom Section - via Reversal)
        if check_horizontal(grid[::-1]):
            return True

        # 3. Check Vertical Cuts (Left Section - via Transposition)
        transposed = [list(row) for row in zip(*grid)]
        if check_horizontal(transposed):
            return True

        # 4. Check Vertical Cuts (Right Section - via Transposed Reversal)
        if check_horizontal(transposed[::-1]):
            return True

        return False