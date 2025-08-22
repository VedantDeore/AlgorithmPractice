class Solution {
    private void reverse(int start, int end, int arr[]){
        int left=start;
        int right=end;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx=-1;
       for(int i=nums.length-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            idx = i;
            break;
        }
       }
        if(idx==-1){
            reverse(0,nums.length-1,nums);
            return;
        }
        
        for(int i=nums.length-1;i>idx;i--){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        
        reverse(idx+1,nums.length-1,nums);
        

    }
}