class Solution {
    public int trap(int[] arr) {
        int leftMax =0 ,rightMax =0 ,total =0,l = 0;
        int r = arr.length-1;

        while (l<r) {
            if(arr[l] <= arr[r]){
                if(leftMax > arr[l] ){
                    total += leftMax - arr[l];
                }else{
                    leftMax = arr[l];
                }
                l= l+1;
            }else{
                if(rightMax > arr[r]){
                    total += rightMax - arr[r];
                }else{
                    rightMax = arr[r];
                }
                r= r-1;
            }
        }
        return total;
    }
}