class Solution:
    def mapWordWeights(self, words: List[str], weights: List[int]) -> str:
        ans = []
        for word in words:
            summ =0
            for char in word:
                summ += weights[ord(char) - ord('a')]

            # print(summ%26)
            ans.append(chr(25 - summ%26  + 97 ))

        return ''.join(ans)