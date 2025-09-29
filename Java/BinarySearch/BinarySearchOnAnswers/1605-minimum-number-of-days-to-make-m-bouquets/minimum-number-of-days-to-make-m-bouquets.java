class Solution {
    private boolean possible(int arr[], int day, int m, int k){
        int cnt=0;
        int noOfBouquets = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= day){
                cnt++;
            }else{
                noOfBouquets += (cnt/k);
                cnt=0;
            }
        }
        noOfBouquets += (cnt/k);

        return (noOfBouquets >= m);
    }
    private int[] findmaxmin(int arr[]){
        int max=arr[0];
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return new int[]{min, max};
    }
    public int minDays(int[] arr, int m, int k) {
        if ((long)m * k > arr.length) return -1;

        int range[] = findmaxmin(arr);
        int low = range[0]; 
        int high = range[1]; 
        while (low<=high) {
            int mid = (low + high)/2;

            if(possible(arr, mid, m, k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}