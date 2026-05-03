class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        ss = s+s
        if len(goal) == len(s) and goal in ss:
            return True
        
        return False
        