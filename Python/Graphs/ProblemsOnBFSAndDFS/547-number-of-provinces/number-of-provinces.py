class Solution:
    
    def bfs(self, start : int, visited : List[int], grid: List[List[int]]) -> None:
        visited[start] = 1

        q = deque()

        q.append(start)

        n = len(grid)

        while q:
            node = q.popleft()
            for neighbour in range(n):
                if grid[node][neighbour] == 1 and visited[neighbour] == 0:
                    visited[neighbour] = 1
                    q.append(neighbour)

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)

        visited = [0]*n

        cnt = 0

        for i in range(n):
                if visited[i] == 0:
                    cnt+=1
                    self.bfs(i,visited,isConnected)
                
        return cnt
        