class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        n = len(s)
        maxi = pow(2,k)
        # print(maxi)
        if n < maxi+k-1:
            return False
        
        l=0
        r=k-1
        # number = 0
        sett = set()
        # while number < maxi:
        #     arr.append(bin(number)[2:].zfill(k))
        #     number+=1
        # cnt=0
        # print(arr)
        while r<n:
            sub = s[l:r+1]
            sett.add(sub)
            l+=1
            r+=1
        
        if len(sett) == maxi:
            return True
        # for i in arr:
        #     # print(i)
        #     if i not in s:
        #         # print(i)
        #         return False

        return False
        