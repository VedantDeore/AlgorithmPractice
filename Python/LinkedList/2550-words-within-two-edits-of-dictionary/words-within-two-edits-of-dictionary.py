class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        ans =[]

        for word1 in queries:
            for word2 in dictionary:
                diff= 0
                for i in range(len(word1)):
                    if word1[i] != word2[i]:
                        diff+=1
                    if diff>2:
                        break

                if diff <= 2:
                    ans.append(word1)
                    break
        
        return ans
        