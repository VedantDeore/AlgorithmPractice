class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        if encodedText.strip() == "":
            return ""
        l = len(encodedText)
        m = l//rows
        n = rows
        ans = []
        mat = []
        idx=0
        for i in range(n):
            row  =[]
            for j in range(m):
                row.append(encodedText[idx])
                idx+=1
            mat.append(row)
        
        # for i in range(n):
        #     for j in range(m):
        #         print(mat[i][j], end="")
        #     # print()
        # print(n, " ", m)
        i=0
        j=0
        p=0
        while True:
            if i==n:
                i=0 
                j=p+1
                p=p+1
                if j==m:
                    break  
            # print("i : " , i , " j :" , j , "p :", p) 
            if j<m and i<n:
                ans.append(mat[i][j])
            i+=1
            j+=1


        # print(ans)

        return "".join(ans).rstrip()
            


            
            
