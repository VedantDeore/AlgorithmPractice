from collections import defaultdict, deque
from typing import List

class Solution:
    def minJumps(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return 0

        mpp = defaultdict(list)
        isPrime = [True] * n

        # Build prime -> indices map
        for i, val in enumerate(nums):

            if val == 1:
                isPrime[i] = False
                continue

            x = val

            # factor 2 separately
            if x % 2 == 0:

                if val != 2:
                    isPrime[i] = False

                mpp[2].append(i)

                while x % 2 == 0:
                    x //= 2

            p = 3

            while p * p <= x:

                if x % p == 0:

                    if val != p:
                        isPrime[i] = False

                    mpp[p].append(i)

                    while x % p == 0:
                        x //= p

                p += 2

            if x > 1:
                mpp[x].append(i)

                if x != val:
                    isPrime[i] = False

        # BFS
        q = deque([0])

        dist = [-1] * n
        dist[0] = 0

        while q:

            idx = q.popleft()

            if idx == n - 1:
                return dist[idx]

            nd = dist[idx] + 1

            # left
            if idx > 0 and dist[idx - 1] == -1:
                dist[idx - 1] = nd
                q.append(idx - 1)

            # right
            if idx + 1 < n and dist[idx + 1] == -1:
                dist[idx + 1] = nd
                q.append(idx + 1)

            # teleport
            if isPrime[idx]:

                prime = nums[idx]

                if prime in mpp:

                    for nxt in mpp[prime]:

                        if dist[nxt] == -1:
                            dist[nxt] = nd
                            q.append(nxt)

                    del mpp[prime]

        return -1