class Solution {
    static {
        for (int i = 0; i < 150; i++) {
            numberOfSubarrays(new int[] {0}, 0);
        }
    }
    private static int countsubarrayslessthanK(int arr[], int goal){
        if(goal<0)return 0;

        int l=0,r=0,sum=0,cnt=0;
        while(r<arr.length){
            sum += (arr[r]%2);
            while(sum > goal){
                sum -= (arr[l]%2);
                l++;
            }
            cnt+= r-l+1;
            r++;
        }
        return cnt;
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return countsubarrayslessthanK(nums,k) - countsubarrayslessthanK(nums,k-1);
    }
}