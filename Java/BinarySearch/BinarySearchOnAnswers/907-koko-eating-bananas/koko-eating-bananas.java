class Solution {
    private int findMax(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    private long calculateHours(int arr[], int hourly){
        long totalHours=0;
        for(int i=0;i<arr.length;i++){
            totalHours += (arr[i] + (long)hourly - 1) / hourly; 
            // totalHours+= (int)Math.ceil((double)arr[i]/(double)hourly);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low<=high){
            int mid = low + ((high-low)>>1);

            if(calculateHours(piles,mid) <= h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}