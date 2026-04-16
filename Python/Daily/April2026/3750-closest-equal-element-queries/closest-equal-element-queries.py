class Solution:
    def find(self, startIndex, n,nums):
        m = len(nums)
        if m <= 1 :
            return -1


        dist = float('inf')
        # dist = float('-inf')
        # dist = float('inf')
        # pos = nums.index(startIndex)
        pos = bisect.bisect_left(nums, startIndex)

        right = nums[(pos + 1)%m]
        d = abs(right- startIndex)
        antic = n-d

        left = nums[(pos - 1 +m )%m]
        d1 = abs(left - startIndex)
        antic1 = n-d1

        dist = min(d,antic, d1, antic1)


        return dist 
        
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        dic = defaultdict(list)
        n = len(nums)
        for i in range(n):
            
            dic[nums[i]].append(i)

        ans = [] 
        for idx in queries:
            num = self.find(idx,n, dic[nums[idx]])
            # print(dic[nums[idx]])
            ans.append(num)

        return ans
