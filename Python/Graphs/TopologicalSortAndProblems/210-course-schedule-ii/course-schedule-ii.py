class Solution:
    
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adjList : List[List[int]]  = []

        n = numCourses
        edges = prerequisites
        for i in range(n):
            adjList.append([])





        for i in range(len(edges)):
            u = edges[i][0]
            v = edges[i][1]

            adjList[v].append(u)



        indegree = [0]*n

        for i in range(n):
            for neighbour in adjList[i]:
                indegree[neighbour] +=1

        q = deque()




        for i in range(n):

            if indegree[i] == 0:
                q.append(i)

        cnt= 0
        
        topo = []

        while q:

            node = q.popleft()
            cnt+=1
            topo.append(node)

            for neighbour in adjList[node]:
                indegree[neighbour] -=1
                if indegree[neighbour] ==0:
                    q.append(neighbour)



        if cnt == n:
            return topo


        return  []