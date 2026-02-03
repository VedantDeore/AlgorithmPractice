class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n = len(s);m = len(t)
        if m>n:
            return ""
        
        l=0;r=0;minlen= int(1e9);cnt=0
        start_index=-1
        hash_arr = [0]*256
        for i in range(m):
            hash_arr[ord(t[i])]+=1
        
        
        while r<n:
            rc = s[r]
            if hash_arr[ord(rc)] >0:
                cnt+=1
            
            hash_arr[ord(rc)] -=1

            while cnt == m:
                if (r-l+1) < minlen:
                    minlen = r-l+1
                    start_index=l
                lc = s[l]

                hash_arr[ord(lc)] +=1
                if hash_arr[ord(lc)] > 0:
                    cnt -=1
                l=l+1
            
            r=r+1
        
        return "" if start_index==-1 else s[start_index:start_index+minlen]
            
        