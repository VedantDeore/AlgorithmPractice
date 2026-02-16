class Solution:
    def reverseBits(self, n: int) -> int:
        s = []
        for _ in range(32):
            s.append(str(n%2))
            n = n //2

        # print(s)
        # s= s[::-1]
        length = len(s)
        p2=1
        num=0
        for i in range(length -1,-1,-1):
            if(s[i] == '1'):
                num = num + p2
            p2 = p2*2

        return num