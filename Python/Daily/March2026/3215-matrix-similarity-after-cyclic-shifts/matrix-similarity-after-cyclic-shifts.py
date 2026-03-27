class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        m = len(mat[0])
        k = k%m

        ans = []
        i=0
        for row in mat:
            if i%2==0:
                ans.append(row[k:] + row[:k])
            else:
                ans.append(row[:-k] + row[-k:])

        return ans==mat