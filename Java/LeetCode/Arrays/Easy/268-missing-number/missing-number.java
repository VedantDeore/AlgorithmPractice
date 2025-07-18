class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int sum = n*(n+1)>>1;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=nums[i];
        }
        return sum -ans;
    }
}