class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        l=0
        s2 = s+s
        n2 = len(s2)
        diff1 = 0
        diff2 = 0
        ans = n
        for r in range(n2):
            if s2[r] != ('0' if r % 2 == 0 else '1'):
                diff1 += 1
            
            if s2[r] != ('1' if r % 2 == 0 else '0'):
                diff2 += 1

            if r - l + 1 > n:
                if s2[l] != ('0' if l % 2 == 0 else '1'):
                    diff1 -= 1
            
                if s2[l] != ('1' if l % 2 == 0 else '0'):
                    diff2 -= 1
                
                l+=1

            if r-l+1 == n:
                ans = min(ans,diff2, diff1)

        
        return ans



        