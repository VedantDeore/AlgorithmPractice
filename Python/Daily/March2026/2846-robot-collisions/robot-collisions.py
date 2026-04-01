class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        if directions.count('L') == len(directions) or directions.count('R') == len(directions):
            return healths

        
        robots = {}
        i=0
        for i in range(len(positions)):
            robots[positions[i]] = [healths[i], directions[i], i]
        
        sorted_keys = sorted(robots.keys())



        stack = []
        # print(sorted_k)

        reserve = []
        for pos in sorted_keys:
            current = robots[pos]
            # print(pos, "", current)
            if current[1] == 'R':
                stack.append(current)
            else:
                while stack:
                    if stack[-1][0] == current[0]:
                        current[0] = 0
                        stack.pop()
                        break
                    elif stack[-1][0] < current[0]:
                        stack.pop()
                        current[0] -=1
                    else:
                        stack[-1][0] -=1
                        current[0] = 0
                        break 

                # print(stack)

                if current[0] !=0:
                    reserve.append(current)   
                    # print("!!!!" , reserve)   
            
            
            
            
        
        # print(stack)
        for i in reserve:
            stack.append(i)
        stack = sorted(stack, key = lambda x:x[2])
        ans=[]
        for i in stack:
            ans.append(i[0])
        return ans

        