class Solution:
    def processStr(self, s: str) -> str:
        res = ''
        n = len(s)
        for i in range(n):
            if s[i] >= 'a' and s[i] <= 'z':
                res += s[i]
            elif s[i] == '*':
                res = res[:-1] 
            elif s[i] == '#':
                res += res
            elif s[i] == '%':
                res = res[::-1]
            
            # print(res)

        return res
        