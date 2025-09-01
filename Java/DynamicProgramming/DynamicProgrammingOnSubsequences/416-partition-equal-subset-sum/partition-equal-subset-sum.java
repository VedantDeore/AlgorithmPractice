class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        if(totalSum %2 != 0)return false;

        int k = totalSum/2;
        
        boolean prev[] = new boolean[k+1];        
        prev[0] = true;
        if(nums[0] <= k){
            prev[nums[0]] = true;
        }

        for(int index=1;index<n;index++){
            boolean curr[] = new boolean[k+1];
            for(int target= 1; target<=k ;target++){
                boolean nottake = prev[target];
                boolean take = false;
                if(target >= nums[index]){
                    take = prev[target - nums[index]];
                }

                curr[target] = (take || nottake);
            }
            prev = curr;
        }
        return prev[k];
    }

}