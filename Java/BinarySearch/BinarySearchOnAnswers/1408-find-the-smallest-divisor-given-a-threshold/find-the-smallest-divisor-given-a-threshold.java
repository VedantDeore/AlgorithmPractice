class Solution {
    private int findmax(int arr[]){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
    private int SumOfD(int arr[], int d){
        int sum = 0;
        for (int val : arr) {
            sum += (val + d - 1) / d;
        }
        return sum;
    }
    public int smallestDivisor(int[] arr, int threshold) {
        int low = 1;
        int high = findmax(arr);
        
        while (low <= high) {
            int mid = (low + high)/2;
                    
            if(SumOfD(arr, mid) <= threshold){
                high= mid-1;
            }else{
                low = mid +1;
            }
        }
        return low;
    }
}