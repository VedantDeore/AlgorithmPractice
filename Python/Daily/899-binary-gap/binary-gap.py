class Solution:
    def binaryGap(self, n: int) -> int:
        maxcnt=0
        cnt=0
        
        l=-1
        r=0

        while r<32:
            bit = (1<<r)&n
            
            if bit != 0:
                if l== -1:
                    l=r
                cnt = r-l
                l=r
                maxcnt = max(maxcnt,cnt)

            r+=1

        
        return maxcnt 
        