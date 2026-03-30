class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        even = [0]*26
        odd = [0]*26

        n = len(s1)

        for i in range(n):
            if i%2 == 0:
                even[ord(s1[i]) - ord('a')]+=1
                even[ord(s2[i]) - ord('a')]-=1
            else:
                odd[ord(s1[i]) - ord('a')]+=1
                odd[ord(s2[i]) - ord('a')]-=1
            
        
        for i in range(26):
            if even[i] != 0 or odd[i] != 0:
                return False
        
        return True