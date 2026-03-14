class Solution:
    j = 0
    def f(self, s:str, n:int, k:int, ans:List[str]):
        if ans[0]!= "":
            return
        global j
        if len(s) == n:
            self.j+=1
            # print(self.j , " ", s)
            if self.j==k:
                ans[0] = s
                return
            return
         
        if s[-1] == 'a':
            self.f(s+'b',n,k,ans)
            self.f(s+'c',n,k,ans)

        if s[-1] == 'b':
            self.f(s+'a',n,k,ans)
            self.f(s+'c',n,k,ans)

        if s[-1] == 'c':
            self.f(s+'a',n,k,ans)
            self.f(s+'b',n,k,ans)

        return 

    def getHappyString(self, n: int, k: int) -> str:

        ans = [""]

        for i in ['a','b','c']:
            self.f(i,n,k,ans)
        
        return ans[0]