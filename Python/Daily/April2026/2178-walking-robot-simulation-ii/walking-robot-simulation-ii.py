class Robot:
    # robo
    # dire
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]

    def __init__(self, width: int, height: int):
        self.grid = [[0,0],[0,width-1], [height-1,0], [height-1, width-1]]
        self.robo = [0,0]
        self.dire = 1
        self.height = height
        self.width = width
        

    def step(self, num: int) -> None:
        if num>0:
            perimeter = 2*(self.height-1 + self.width-1)
            num %= perimeter

            if num == 0 and self.robo == [0, 0]:
                self.dire = 2
        for _ in range(num):
            nextx = self.robo[0] + self.dx[self.dire]
            nexty = self.robo[1] + self.dy[self.dire]

            if nextx >= 0 and nextx <= self.width-1 and nexty >= 0 and nexty <= self.height-1:
                self.robo[0] = nextx
                self.robo[1] = nexty
            else:
                while (nextx < 0 or nextx > self.width-1) or (nexty < 0 or nexty > self.height-1):
                    self.dire = (self.dire + 3)%4
                    nextx = self.robo[0] + self.dx[self.dire]
                    nexty = self.robo[1] + self.dy[self.dire]
                self.robo[0] = nextx
                self.robo[1] = nexty

            # print(self.robo)
            # print(self.dire)

        # print("ended")
        

    def getPos(self) -> List[int]:
        return [self.robo[0],self.robo[1]]
        

    def getDir(self) -> str:
        directions = ('North', 'East', 'South', 'West')
        return directions[self.dire]


# Your Robot object will be instantiated and called as such:
# obj = Robot(width, height)
# obj.step(num)
# param_2 = obj.getPos()
# param_3 = obj.getDir()