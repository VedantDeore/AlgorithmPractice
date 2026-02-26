class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        lis={}
        for i in arr:
            cnt = bin(i).count('1')
            if cnt in lis:
                lis[cnt].append(i)
            else:
                lis[cnt] = [i]

        # for i in lis:
        #     print(lis[i])
        lis2 = dict(sorted(lis.items()))

        # for i in lis2:
        #     print(lis2[i])
        # print(lis2)
        ans = []
        for key in lis2:
            l2 = sorted(lis2[key])
            for data in l2:
                ans.append(data)


        return ans
