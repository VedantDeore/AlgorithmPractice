import math
class Solution:
    def check(self, mid:int, workerTimes: List[int], mountainHeight:int)->bool:
        h = 0

        for t in workerTimes:
            h += int(math.sqrt((2 * mid / t) + 0.25) - 0.5)

            if h>=mountainHeight:
                return True
            
        return True if h>=mountainHeight else False

    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        low = 1
        high = min(workerTimes)*mountainHeight*(mountainHeight+1)//2

        ans=0

        while low<=high:
            mid = low + ((high - low) >> 1)

            if (self.check(mid, workerTimes, mountainHeight)):
                ans = mid
                high = mid-1
            else:
                low = mid+1

        return ans
                

        