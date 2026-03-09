class Solution:
    def binstrRec(self, s, i, res):
        n = len(s)

        # if string is complete, add to result
        if i == n:
            res.append("".join(s))
            return

        # assign '0' at current position
        s[i] = '0'
        self.binstrRec(s, i + 1, res)

        # assign '1' at current position
        s[i] = '1'
        self.binstrRec(s, i + 1, res)
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        
        s = ['0']*len(nums[0])
        res = []
        self.binstrRec(s,0,res)


        for i in range(len(res)):
            if res[i] not in nums:
                return res[i] 

    
        