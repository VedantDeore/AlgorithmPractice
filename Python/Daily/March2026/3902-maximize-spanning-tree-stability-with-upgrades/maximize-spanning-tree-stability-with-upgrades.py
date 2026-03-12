class DisjointSet:
    def __init__(self,n:int):
        self.parent = list(range(n + 1))
        self.rank = [0] * (n + 1)
        self.components = n

    

    def findUParent(self, node:int) -> int:
        if node == self.parent[node]:
            return node

        ulp = self.findUParent(self.parent[node])
        self.parent[node] = ulp
        return ulp

    def UnionByRank(self, u:int, v:int)->int:
        ulp_u = self.findUParent(u)
        ulp_v = self.findUParent(v)

        if ulp_u == ulp_v:
            return 
            
        if self.rank[ulp_u] < self.rank[ulp_v]:
            self.parent[ulp_u]  = ulp_v
        elif self.rank[ulp_u] > self.rank[ulp_v]:
            self.parent[ulp_v] = ulp_u
        else:
            self.parent[ulp_v] = ulp_u
            self.rank[ulp_u] = self.rank[ulp_u] + 1

class Solution:
    def check(self, n:int, edges: List[List[int]], k:int, mid:int)->bool:
        dsu = DisjointSet(n)
        upgradeCandidates : List[List[int]] =[]


        for edge in edges:
            u = edge[0]
            v = edge[1]
            s = edge[2]
            m = edge[3]

            if m ==1:
                if s < mid:
                    return False
            
                dsu.UnionByRank(u,v)
            else:
                if s>= mid:
                    # no need to upgrage
                    dsu.UnionByRank(u,v)
                elif 2*s >= mid:
                    upgradeCandidates.append([u,v])

                    # k-=1

        for edge in upgradeCandidates:
            u = edge[0]
            v = edge[1]

            if dsu.findUParent(u) != dsu.findUParent(v):
                if k <=0:
                    return False 
                dsu.UnionByRank(u,v)
                k-=1 # upgrade

        root = dsu.findUParent(0)

        for i in range(n):
            if dsu.findUParent(i) != root:
                return False

        return True


        

    def maxStability(self, n: int, edges: List[List[int]], k: int) -> int:
        # if m == 1 , check all for cylce
        """
        Input: n = 3 edges = [[0,1,1,1], [1,2,1,1], [2,0,1,1]], k = 0
        0 1 2 parent = 0
        (2,0)
        2 ka. parent kaun hai = 0
        0 ka parent kaun hai = 0
        """
        dsu = DisjointSet(n)

        for edge in edges:
            u = edge[0]
            v = edge[1]
            s = edge[2]
            m = edge[3]

            if m ==1:
                if dsu.findUParent(u) == dsu.findUParent(v):
                    return -1

                dsu.UnionByRank(u,v)

        result = -1

        low = 1
        high = 10**9

        while low<= high:
            mid = low + ((high - low) >> 1)

            if self.check(n, edges, k, mid):
                result = mid
                low = mid+1
            else:
                high = mid-1
                
        return result
