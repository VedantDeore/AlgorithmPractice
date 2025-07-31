class Solution {
    public void reverse(int a[], int st, int end){
        while(st<=end){
        int temp = a[st];
        a[st] = a[end];
        a[end] = temp;
        st++;
        end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k = k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
     
    }
}