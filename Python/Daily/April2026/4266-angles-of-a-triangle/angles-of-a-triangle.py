class Solution:
    def internalAngles(self, sides: list[int]) -> list[float]:
        ans =[]
        sides = sorted(sides)
        a,b,c = sides[0],sides[1], sides[2]
        if (a+b> c):
            n = (a**2 + b**2 - c**2)
            d = (2*a*b)
            cos_c = n/d
            cos_c = max(-1.0, min(1.0, cos_c)) 

            C = math.degrees(math.acos(cos_c))


            n = (a**2 + c**2 - b**2)
            d = (2*a*c)
            cos_b = n/d
            cos_b = max(-1.0, min(1.0, cos_b))
            B = math.degrees(math.acos(cos_b))

            return sorted([180-B-C, B,C])
        
        return []
        