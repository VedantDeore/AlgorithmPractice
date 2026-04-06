class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:

        dx = [0,1,0,-1]
        dy = [1,0,-1,0]

        currentdir=0

        start = [0,0]
        x=0
        y=0
        ans=0 
        obstacle_set = {(ob[0], ob[1]) for ob in obstacles}
        for command in commands:
            if command>0:
                for i in range(1, command+1):
                    x += dx[currentdir]
                    y += dy[currentdir]

                    if (x, y) in obstacle_set:
                        x-= dx[currentdir]
                        y-= dy[currentdir]
                        # start = max(start, [abs(x),abs(y)])

                        break
                # print(x,y)
                ans = max(ans,x*x+y*y)

            if command == -1:
                currentdir = (currentdir + 1)%4
            elif command == -2:
                currentdir = (currentdir +3)%4
        # print(start)
        return ans
        


        
        