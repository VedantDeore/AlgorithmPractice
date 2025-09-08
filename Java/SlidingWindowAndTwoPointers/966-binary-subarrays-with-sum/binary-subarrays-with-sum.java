class Solution {
    private int sumLessThanEqualToK(int arr[], int goal){
        if(goal<0)return 0;
        int l=0,r=0,sum=0,cnt=0;
        while(r<arr.length){
            sum+= arr[r];
            while(sum> goal){
                sum-= arr[l];
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sumLessThanEqualToK(nums,goal) - sumLessThanEqualToK(nums,goal-1);
    }
}