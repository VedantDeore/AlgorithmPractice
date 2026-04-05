class Solution:
    def judgeCircle(self, moves: str) -> bool:
        start= [0,0]
        for move in moves:
            if move == 'U':
                start[1] +=1
            elif move == 'D':
                start[1] -=1
            elif move == 'L':
                start[0] -=1
            else:
                start[0] +=1

        return True if (start[0] == 0 and start[1] == 0) else False