class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        n = len(landStartTime)    
        m = len(waterStartTime)

        land = float('inf')
        water = float('inf')
        land_water = float('inf')
        water_land = float('inf')

        for i in range(n):
            land = min(land, landStartTime[i] + landDuration[i])

        for i in range(m):
            water =  min(water, waterStartTime[i] + waterDuration[i])
            land_water =  min(land_water, max(waterStartTime[i] , land) + waterDuration[i])


        for i in range(n):
            water_land =  min(water_land, max(landStartTime[i] , water) + landDuration[i])


        return min(water_land, land_water)