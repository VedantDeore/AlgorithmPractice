class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        s3 = list(s1)
        ans = False

        s3[0] ,s3[2] = s3[2],s3[0]

        print(s3)
        if "".join(s3) == s2:

            ans = True
            return ans


        s3[1] ,s3[3] = s3[3],s3[1]

        print(s3, " ", s2)

        if "".join(s3) == s2:
            ans = True
            return ans
        
        if not ans:
            s4 = list(s2)
            s4[0] ,s4[2] = s4[2],s4[0]

            if s1 == "".join(s4) or s4 == s3:
                ans = True
                return ans


            s4[1] ,s4[3] = s4[3],s4[1]

            if s1 == "".join(s4) or s4 == s3:
                ans = True
                return ans

        return ans
        


        