class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        n = len(nums)
        pre= [-1]*n
        minn = float('inf')
        for i in range(n-1,-1,-1):
            minn = min(minn, nums[i])
            pre[i] = minn
        print(pre)

        ans=float('inf')
        ind = -1
        for i in range(n):
            iss = max(nums[:i+1]) - pre[i]
            if iss <= k :
                if iss < ans:
                    ans = iss
                    ind = i
                    break

        return ind if ans != float('inf') else -1

    