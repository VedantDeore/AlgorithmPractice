class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        x=n
        while True:
            arr = list(map(int, str(x)))
            prod = math.prod(arr)
            if prod%t==0:
                return x
            x+=1
        return -1