class Solution:
    def getLength(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 1


        for i in range(n):
            dic = {}
   
            freq = {}

            for j in range(i,n):         
                old_freq = dic.get(nums[j], 0)

                if old_freq > 0:
                    freq[old_freq] -= 1

                    if freq[old_freq] == 0:
                        del freq[old_freq]

                dic[nums[j]] = old_freq + 1
                new_freq = old_freq + 1

                freq[new_freq] = freq.get(new_freq, 0) + 1

                

                if len(freq) == 2:
                    mini = min(freq)
                    maxi = max(freq)
                    if mini*2 == maxi:
                        ans = max(ans, j-i+1)
                        print(ans)

                if len(freq) == 1 and len(dic) == 1:
                    ans = max(ans, j-i+1)
                        

        return ans 
                    
                
        

        