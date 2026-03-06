class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        ones = s.count('1')
        n = len(s)
        cnt=0
        for i in range(n):
            while i<n and s[i] == '1':
                cnt+=1
                i+=1
            if cnt != 0:
                break
            
        if cnt == ones:
            return True
        return False


        