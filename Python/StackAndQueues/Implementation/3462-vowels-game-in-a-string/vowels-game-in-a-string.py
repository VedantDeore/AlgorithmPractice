class Solution:
    def doesAliceWin(self, s: str) -> bool:
        vow = ['a','e','i','o','u']

        i=0
        cnt=0
        n = len(s)
        while i < n:
            if s[i] in vow:
                cnt+=1
            i+=1
            
        if cnt==0:
            return False

        if cnt %2 != 0:
            return True
        else:
            if (cnt -1) %2 !=0:
                return True
            return False
        