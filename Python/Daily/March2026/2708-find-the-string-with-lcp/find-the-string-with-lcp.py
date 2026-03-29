class Solution:
    def checklcp(self, word):
        n = len(word)

        lcp = [[0]*n for _ in range(n)]

        for i in range(n):
            lcp[i][n-1] = 1 if (word[i] == word[n-1]) else 0 

        for j in range(n):
            lcp[n-1][j] = 1 if (word[j] == word[j-1]) else 0


        for i in range(n-1,-1,-1):
            for j in range(n-1,-1,-1):
                if word[i] == word[j]:
                    lcp[i][j] = 1 + (lcp[i+1][j+1] if (i+1 < n and j+1 < n) else 0)
                else:
                    lcp[i][j] = 0

        return lcp
                

        
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        word = ["$"]*n

        for i in range(n):
            for j in range(i):
                if lcp[j][i] != 0:
                    word[i] = word[j]
                    break

            if word[i] == "$":
                forbidden = [False]*26
                for j in range(i):
                    if lcp[j][i] == 0:
                        forbidden[ord(word[j]) - ord('a')] = True

                # a,b,c,
                for idx in range(26):
                    if forbidden[idx] == False:
                        word[i] =chr(ord('a') + idx)
                        break

                if word[i] == "$":
                    return ""

        return ''.join(word)  if self.checklcp(word) == lcp else "" 
