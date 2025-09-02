class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int d = target;
        for(int x: nums) totalSum += x;

        if (Math.abs(target) > totalSum) return 0;
        if ((totalSum + target) % 2 != 0) return 0;

        
        if(totalSum - d < 0 && totalSum -d % 2== 0) return -1;

        int sum = (totalSum + d) / 2;

        int prev[] = new int[sum+1];

        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= sum){
            prev[nums[0]] = 1;
        }

        for(int index=1;index<nums.length;index++){
            int curr[] = new int[sum +1];
            curr[0] = 1;
            for(int s= 0 ;s<= sum;s++){
                int notpick = prev[s];
                int pick = 0;
                if(nums[index] <= s){
                    pick = prev[s - nums[index]];
                }
                curr[s] = pick + notpick;
            }
            prev= curr;
        }
        return prev[sum];
    }
}