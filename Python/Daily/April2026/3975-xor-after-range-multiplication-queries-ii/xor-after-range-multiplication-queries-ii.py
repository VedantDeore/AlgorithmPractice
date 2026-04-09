import math
class Solution:
    
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:

        M = 10**9 + 7  # Example modulo (1000000007), adjust as needed for your     specific problem

        def power(a, b):
            if b == 0:
                return 1
            
            half = power(a, b // 2)
            result = (half * half) % M
            
            if b % 2 == 1:
                result = (result * a) % M
                
            return result

        # Example usage for Fermat's Little Theorem (finding modular inverse of a):
        # inverse = power(a, M - 2)
        ans=0
        n = len(nums)

        mpp = collections.defaultdict(list)

        block_size = math.ceil(math.sqrt(n))


        for l,r,k,v in queries:
        

            if k> block_size:
                for i in range(l, r+1,k):
                    nums[i] = (nums[i]*v)%M
            else:
                mpp[k].append([l,r,k,v])

        
        for key, value in mpp.items():
            diff = [1]*n

            for [l,r,k,v] in value:
                diff[l] = (diff[l]*v)%M

                steps = (r-l)//k
                nextt = l + (steps+1)*k

                if (nextt < n):
                    diff[nextt] = (diff[nextt] * power(v, M-2)) % M
            
            for i in range(n):
                if i-k>=0: 
                    diff[i] = (diff[i]*diff[i-k])%M

            for i in range(n):
                nums[i] = (nums[i]*diff[i])%M


        for i in range(n):
            ans = ans^nums[i]

        return ans
                     
            
        