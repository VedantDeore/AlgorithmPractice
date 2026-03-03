class Solution:
    def findKthBit(self, n: int, k: int) -> str:

        s1 = '0'
        
        translate_table = str.maketrans("10", "01")
        for i in range(n):
            if i >=1:
                # print(s1)
                srev= s1.translate(translate_table)
                # print(srev)
                s1 = s1 + '1' + srev[::-1]

        
        # print(s1)
        for i in range(len(s1)):
            if i == k-1:
                return s1[i]
        
        return -1

    
         