class Solution:
    def same(self, word, str2, i,m):
        for j in range(m):
            if word[i] != str2[j]:
                return False
            i+=1
        return True

    def generateString(self, str1: str, str2: str) -> str:
        n= len(str1)
        m= len(str2)

        N = n+m-1

        word = ['$']*N
        canchange = [False]*N

        for i in range(n):
            if str1[i] == 'T':
                i_ = i
                for j in range(m):
                    # word[i] = str2[j]
                    # word[i+1] = str2[j+1]
                    if(word[i_] != '$' and word[i_] != str2[j]):
                        return ""
                    word[i_]= str2[j]
                    i_ +=1

        # fill remaining spaces with 'a'

        for i in range(N):
            if(word[i] == '$'):
                word[i] = 'a'
                canchange[i] = True
        
        # processing F

        for i in range(n):
            if str1[i] == 'F':
                if self.same(word, str2, i, m):

                    changed = False
                    for j in range(i + m - 1,i-1,-1):
                        if canchange[j] == True:
                            word[j] = 'b'
                            changed = True
                            break
                    if not changed:
                        return ""

        return "".join(word)
                        


                    
        