class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l=0
        r=0
        n=len(s)
        
        maxlen=0
        mapp : Dict[str, int]= {}
        max_freq = 0
        while r < n:
            mapp[s[r]] = mapp.get(s[r],0) + 1
            max_freq = max(max_freq, mapp[s[r]])

            if (r - l + 1) - max_freq  > k:
                # while len(mapp) > k:
                mapp[s[l]]  -= 1
                if mapp[s[l]] == 0:
                    del mapp[s[l]]
                l+=1
            
            
            maxlen = max(maxlen, r-l+1)

            r+=1
            
        return maxlen