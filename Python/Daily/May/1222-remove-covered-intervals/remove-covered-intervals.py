class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        # print(intervals)
        n = len(intervals)
        ans = n
        cnt = 0
        maxi = [intervals[0][0], intervals[0][1]]
        for i in range(1,n):
            a = maxi[0]
            b = maxi[1]
            c = intervals[i][0]
            d = intervals[i][1]

            if a<=c and b>=d:
                cnt+=1
            else:
                maxi[0] = c
                maxi[1] = d

            
        
        return n - cnt

        