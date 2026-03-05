class Solution:
    def minOperations(self, s: str) -> int:

        o1 = '0'
        c1 = 0
        o2 = '1'
        c2 = 0
        n = len(s)
        for i in range(n):
            if o1 == '0':
                if s[i] == '1':
                    c1+=1
            if o2 == '0':
                if s[i] == '1':
                    c2+=1
            if o1 == '1':
                if s[i] == '0':
                    c1+=1
            if o2 == '1':
                if s[i] == '0':
                    c2+=1
            
            if o1 == '1':
                o1 = '0'
            else:
                o1 = '1'

            if o2 == '1':
                o2 = '0'
            else:
                o2 = '1'

        return min(c1,c2)



        