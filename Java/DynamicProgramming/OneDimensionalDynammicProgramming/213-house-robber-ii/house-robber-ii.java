class Solution {
    private int max(int nums[], int start, int end){
        int prev= nums[start];
        int prev2 = 0;

        for(int i= start +1 ;i<= end;i++){
            int take = nums[i] + prev2;
            int nottake = prev;

            int curri = Math.max(take, nottake);
            
            prev2= prev;
            prev= curri;
        }
        return prev;
    }
    public int rob(int[] nums) {
        if(nums.length ==1)return nums[0];

        int maxf = max(nums, 0, nums.length-2);
        int maxl = max(nums, 1, nums.length-1);

        return Math.max(maxf,maxl); 
    }
}