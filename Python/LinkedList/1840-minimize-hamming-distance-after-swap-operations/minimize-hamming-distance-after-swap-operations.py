from typing import List
from collections import defaultdict, Counter

class DisjointSet:
    def __init__(self, n: int):
        self.parent = [i for i in range(n)]
        self.size = [1] * n

    def findUParent(self, node: int) -> int:
        if node != self.parent[node]:
            self.parent[node] = self.findUParent(self.parent[node])
        return self.parent[node]

    def union(self, u: int, v: int) -> None:
        pu = self.findUParent(u)
        pv = self.findUParent(v)

        if pu == pv:
            return

        if self.size[pu] < self.size[pv]:
            self.parent[pu] = pv
            self.size[pv] += self.size[pu]
        else:
            self.parent[pv] = pu
            self.size[pu] += self.size[pv]


class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        n = len(source)
        ds = DisjointSet(n)
        for u, v in allowedSwaps:
            ds.union(u, v)

        groups = defaultdict(list)
        for i in range(n):
            parent = ds.findUParent(i)
            groups[parent].append(i)

        ans = 0

        for indices in groups.values():
            freq = Counter()

            for i in indices:
                freq[source[i]] += 1

            for i in indices:
                if freq[target[i]] > 0:
                    freq[target[i]] -= 1
                else:
                    ans += 1

        return ans