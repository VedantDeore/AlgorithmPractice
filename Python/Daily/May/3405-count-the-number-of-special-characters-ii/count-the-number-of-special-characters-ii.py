class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        upper = [-1]*26
        lower = [-1]*26
        n = len(word)
        for i in range(n):
            if word[i].isupper():
                ch = ord(word[i]) - ord('A')
                if upper[ch] == -1:
                    upper[ch] = i
            else:
                ch = ord(word[i]) - ord('a')
                lower[ch]  = i

        cnt= 0
        for i in range(26):
            if upper[i] != -1  and lower[i] != -1 :
                if upper[i] > lower[i]:
                    cnt+=1

        return cnt
        
        return len(upper & lower)