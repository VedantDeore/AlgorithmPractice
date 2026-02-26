class Solution:
    def numSteps(self, s: str) -> int:
        n = int(s,2)
        steps=0
        while n>1:
            if n%2 !=0:
                n+=1
            else:
                n  = n>> 1
            steps+=1

        return steps
        