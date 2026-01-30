class Solution:
    def bfs(self, start:int,adjList: List[List[int]], color:List[int]):
        q = deque()
        q.append(start)

        color[start] = 0

        while q:
            node = q.popleft()

            for neighbour in adjList[node]:
                if color[neighbour] == -1:
                    color[neighbour] = 1- color[node]
                    q.append(neighbour)
                elif color[neighbour] == color[node]:
                    return False

        return True

    def dfs(self, node:int, current_color:int, adjList: List[List[int]], color: List[int]):
        color[node] = current_color


        for neighbour in adjList[node]:
            if(color[neighbour] == -1):
                if(self.dfs(neighbour, 1-current_color, adjList, color) == False):
                    return False
            elif color[neighbour] == current_color:
                return False
        
        return True

    def isBipartite(self, graph: List[List[int]]) -> bool:
        color: List[int] = [-1]*len(graph)

        for i in range(len(graph)):
            if color[i] == -1:
                if self.dfs(i, color[i], graph, color) == False:
                    return False
        
        return True