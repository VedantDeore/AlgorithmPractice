class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        aster = sorted(asteroids)
        # print(aster)
        i=0
        n = len(asteroids)
        while i < n:
            if mass < aster[i]:
                break
            mass += aster[i]
            # print(mass)
            i+=1
        # print(i)
        if i == n:
            return True
        else:
            return False
        