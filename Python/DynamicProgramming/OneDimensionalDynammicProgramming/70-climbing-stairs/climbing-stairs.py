class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        prev = 1
        prev2 = 1

        for i in range(2, n + 1):
            curri = prev + prev2
            prev2 = prev
            prev = curri

        return prev
        