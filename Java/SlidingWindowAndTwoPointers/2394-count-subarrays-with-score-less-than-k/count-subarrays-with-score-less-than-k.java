class Solution {
    public long countSubarrays(int[] arr, long k) {
        if(k<0)return 0;
        int l=0,r=0;
        long sum=0,cnt=0;
        while(r<arr.length){
            sum+= (long)arr[r];
            while(sum*(r-l+1L) >= k ){
                sum-= (long)arr[l];
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}