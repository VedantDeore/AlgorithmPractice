class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        n = len(s)
        ans=0

        prev=0
        curr=1

        for i in range(1, n):
            if s[i] == s[i-1]:
                curr+=1
            else:
                ans+= min(curr,prev)
                prev=curr
                curr=1
        
        ans += min(curr,prev)

        return ans
                
            
        