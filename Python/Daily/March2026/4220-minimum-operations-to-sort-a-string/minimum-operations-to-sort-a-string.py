class Solution:
    def minOperations(self, s: str) -> int:
        if s == "".join(sorted(s)): return 0
        if len(s) < 3: return -1
        
        
        min_val, max_val = min(s), max(s)
        min_idx = s.find(min_val)
        max_idx = s.rfind(max_val)
        
        if min_idx == 0 or max_idx == len(s) - 1:
            return 1
        if min_idx == len(s) - 1 and max_idx == 0:
            return 3
        return 2