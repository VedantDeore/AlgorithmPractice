class Solution:
    def minimumIndex(self, capacity: list[int], itemSize: int) -> int:
        ans = -1

        prev = -1
        for i in range(len(capacity)):
            if capacity[i] >= itemSize:
                if prev == -1:
                    ans = i
                    prev = capacity[i]
                if prev != -1 and capacity[i] < prev:
                    ans = i
                    prev = capacity[i]
                    

        return ans

            
        