class Solution:
    def findDiff(self, mat, sti,endi, stj, endj):
        flt=[]
        for i in range(sti, endi+1):
            for j in range(stj, endj+1):
                flt.append(mat[i][j])

        srt = list(sorted(set(flt)))
        # print(srt)
        mindiff=10**7
        
        for i in range(1,len(srt)):
            diff = abs(srt[i-1] - srt[i])
            if diff < mindiff:
                mindiff = diff

        return mindiff if mindiff!= 10**7 else 0

    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        
        n = len(grid)
        m = len(grid[0])

        sti=0
        endi = k-1

        submat : List[List[int]] = []
        ans=0
        while endi < n:
            sub =[]
            stj=0
            endj=k-1
            while endj < m:
                ans= self.findDiff(grid, sti , endi, stj, endj)
                sub.append(ans) 

                stj+=1
                endj+=1
            submat.append(sub)
            
            sti+=1
            endi+=1

        return submat


                


        