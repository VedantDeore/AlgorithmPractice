class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjList = [[] for i in range(n+1)]

        m = len(times)

        for i in range(m):
            u = times[i][0]
            v = times[i][1]
            time = times[i][2]
            adjList[u].append([v,time])
        
        dist = [int(1e9)]*(n+1)
        dist[0]=0
        dist[k]=0

        q=[]
        # time, node
        heapq.heappush(q,(0,k))

        while q:
            time,node = heapq.heappop(q)

            for neighbour in adjList[node]:
                adjNode = neighbour[0]
                edgeWeight = neighbour[1]
                if(time + edgeWeight < dist[adjNode]):
                    dist[adjNode] = time + edgeWeight
                    heapq.heappush(q,(dist[adjNode], adjNode))
        
        mintime=0
        for i in range(1,n+1):
            if(dist[i] == int(1e9)):
                return -1
            mintime = max(mintime, dist[i])
        return mintime


            
