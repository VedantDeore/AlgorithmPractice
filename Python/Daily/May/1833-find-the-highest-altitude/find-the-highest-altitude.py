class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        n = len(gain)
        ans = [0]
        prev = 0
        for i in range(n):
            curr = prev + gain[i]
            ans.append(curr)
            prev = curr

        return max(ans) 
        