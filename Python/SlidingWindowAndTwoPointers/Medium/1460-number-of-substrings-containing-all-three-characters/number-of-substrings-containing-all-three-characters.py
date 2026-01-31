class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        lastseen = [-1,-1,-1]
        n = len(s)
        maxcnt=0
        for i in range(n):
            lastseen[ord(s[i]) - ord('a')]  = i
            if lastseen[0] != -1 and lastseen[1] != -1 and lastseen[1] != -1:
                maxcnt = maxcnt + 1+ min(lastseen[0],lastseen[1],lastseen[2])
        
        return maxcnt