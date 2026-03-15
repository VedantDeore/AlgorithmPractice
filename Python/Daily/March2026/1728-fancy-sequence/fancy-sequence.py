class Fancy:
    M = 10**9 + 7
    seq : List[int] 
    add :int
    mul :int

    def __init__(self):
        self.seq = []
        self.add = 0
        self.mul = 1
    # //Binary Exponentiation for Fermat's Little Theorem -> power(mult, M-2);
    def power(self, a,b):
        return pow(a, b, self.M)



    def append(self, val: int) -> None:
        inv_mul = self.power(self.mul, self.M - 2)
        x = ((val - self.add) * inv_mul) % self.M
        self.seq.append(x)
        

    def addAll(self, inc: int) -> None:
        self.add = (self.add + inc) % self.M
        

    def multAll(self, m: int) -> None:
        self.mul = (self.mul* m) % self.M
        self.add = (self.add* m) % self.M
        

    def getIndex(self, idx: int) -> int:
        if idx >= len(self.seq):
            return -1

        x = ((self.seq[idx] *self.mul) + self.add) % self.M
        return x


# Your Fancy object will be instantiated and called as such:
# obj = Fancy()
# obj.append(val)
# obj.addAll(inc)
# obj.multAll(m)
# param_4 = obj.getIndex(idx)