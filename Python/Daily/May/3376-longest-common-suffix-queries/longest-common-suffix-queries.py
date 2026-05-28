class Solution:

    class TrieNode:
        def __init__(self, idx):
            self.idx = idx
            self.children = [None] * 26

    def getNode(self, i):
        return self.TrieNode(i)

    def insertTrie(self, pCrawl, i, wordsContainer):
        word = wordsContainer[i]
        n = len(word)

        for j in range(n - 1, -1, -1):
            ch_idx = ord(word[j]) - ord('a')

            if pCrawl.children[ch_idx] is None:
                pCrawl.children[ch_idx] = self.getNode(i)

            pCrawl = pCrawl.children[ch_idx]

            if len(wordsContainer[pCrawl.idx]) > n:
                pCrawl.idx = i

    def search(self, pCrawl, word):
        result_idx = pCrawl.idx
        n = len(word)

        for i in range(n - 1, -1, -1):
            ch_idx = ord(word[i]) - ord('a')

            pCrawl = pCrawl.children[ch_idx]

            if pCrawl is None:
                return result_idx

            result_idx = pCrawl.idx

        return result_idx

    def stringIndices(self, wordsContainer, wordsQuery):
        m = len(wordsContainer)
        n = len(wordsQuery)

        result = [0] * n

        root = self.getNode(0)

        for i in range(m):
            if len(wordsContainer[root.idx]) > len(wordsContainer[i]):
                root.idx = i

            self.insertTrie(root, i, wordsContainer)

        for i in range(n):
            result[i] = self.search(root, wordsQuery[i])

        return result