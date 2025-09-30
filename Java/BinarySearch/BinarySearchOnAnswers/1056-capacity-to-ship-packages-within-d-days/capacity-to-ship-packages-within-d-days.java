class Solution {
    private int[] findRange(int arr[]){
        int max = arr[0];
        int sum = arr[0];
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        return new int[]{max,sum};
    }
    private int findDays(int weights[], int cap){
        int days =1;
        int load = 0;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > cap){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int range[] = findRange(weights);
        int low = range[0];
        int high = range[1];

        while(low<=high){
            int mid = low + ((high -low)>>1);

            int d = findDays(weights, mid);
            if(d <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}