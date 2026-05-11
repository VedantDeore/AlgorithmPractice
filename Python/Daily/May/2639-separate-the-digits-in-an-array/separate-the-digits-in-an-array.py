class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            n=10
            lis = []
            while num>0:
                digit = num%10
                lis.append(digit)
                num = num//10
            ans.extend(lis[::-1])

        return ans