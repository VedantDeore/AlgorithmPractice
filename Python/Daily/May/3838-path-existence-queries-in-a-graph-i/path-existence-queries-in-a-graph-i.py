class DisjointSet:
    # TC -> 4 alpha

    """
    ulp is just a variable name used.
        It stands for Ultimate Parent.

        Why "ultimate parent"?

        In a disjoint set, every node points to a parent, 
        and through repeated parent links you 
        eventually reach the representative (root) of that set. 
    """
    
    def __init__(self, n: int):
        self.rank: List[int] = []
        self.parent: List[int] = []
        self.size: List[int] = []
        
        for i in range(n + 1):
            self.parent.append(i)
            self.rank.append(0)
    
    def findUParent(self, node: int) -> int:
        if node == self.parent[node]:
            return node
        
        # ulp = findUParent(parent.get(node))
        # parent.set(node, ulp)
        # return parent.get(node)
        ulp = self.findUParent(self.parent[node])
        self.parent[node] = ulp  # path compression
        return ulp
    
    def UnionByRank(self, u: int, v: int) -> None:
        ulp_u = self.findUParent(u)
        ulp_v = self.findUParent(v)
        
        if ulp_u == ulp_v:
            return
        
        if self.rank[ulp_u] < self.rank[ulp_v]:
            self.parent[ulp_u] = ulp_v
        elif self.rank[ulp_u] > self.rank[ulp_v]:
            self.parent[ulp_v] = ulp_u
        else:
            self.parent[ulp_v] = ulp_u
            self.rank[ulp_u] = self.rank[ulp_u] + 1
    
    

class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        ds = DisjointSet(n)
        i=0
        j=1
        while i<n and j< n:
            if abs(nums[i] - nums[j]) <= maxDiff:
                ds.UnionByRank(i, j)
                j+=1
            else:
                i+=1
            
        # print(ds.parent)
        # print(ds.rank)

        ans = []
        for query in queries:
            if ds.findUParent(query[0]) == ds.findUParent(query[1]):
                ans.append(True)
            else:
                ans.append(False)

        return ans