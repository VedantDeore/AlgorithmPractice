class Solution {
    private boolean CanWePlace(int stalls[], int dist, int cows){
        int cntCows=1;
        int last = stalls[0];
        for (int i = 0; i < stalls.length; i++) {
            if(stalls[i] - last >= dist){
                cntCows++;
                last = stalls[i];
            }
            if(cntCows >= cows) return true;
        }
        return false;
    }
    public int maxDistance(int[] arr, int cows) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length-1] - arr[0];

        while (low<=high) {
            int mid = (low+high)/2;
            if(CanWePlace(arr, mid, cows)) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}