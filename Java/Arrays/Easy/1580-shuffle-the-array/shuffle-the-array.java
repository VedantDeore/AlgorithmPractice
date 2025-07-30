class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int [nums.length];
        for(int i=0,j=n,k=0; i<n && j< nums.length; i++,j++,k++){
            ans[k++] = nums[i];
            //  System.out.println(k++);
            ans[k] = nums[j];
        }
        return ans;
    }
}