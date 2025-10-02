class Solution {
    private int[] findRange(int arr[]){
        int max=arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        return new int[]{max,sum};
    }
    private int findPage(int arr[], int pages){
        int student=1;
        int pagesPerStudent =0;

        for (int i = 0; i < arr.length; i++) {
            if(pagesPerStudent + arr[i] <= pages){
                pagesPerStudent += arr[i];
            }else{
                student++;
                pagesPerStudent = arr[i];
            }
        }
        return student;
    }
    public int splitArray(int[] books, int m) {
        if(books.length <m)return -1;

        int range[] = findRange(books);
        int low = range[0];
        int high = range[1];

        while(low<=high) {
            int mid = (low+high)/2;
            if(findPage(books, mid) <= m ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}