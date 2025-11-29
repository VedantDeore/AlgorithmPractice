class Solution {
    public int minOperations(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum%k;
        // if(sum%k==0){
        //     return 0;
        // }else{
        //     for(int i=0;i<nums.length;i++){
        //         sum -= nums[i];
        //         int temp = nums[i];
        //         while(nums[i] > 0){
        //             nums[i]--;
        //             sum += nums[i];
        //             if(sum %k == 0){
        //                 min = Math.min(sum,min);
        //             }
        //             sum -= nums[i];
        //         }
        //         nums[i] = temp;
        //     }
        // }
        // return min;
    }

}