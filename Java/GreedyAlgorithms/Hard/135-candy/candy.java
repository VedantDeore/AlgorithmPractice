class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int left[] = new int[N];
        left[0] = 1;
        // int right[] = new int[N];
        // right[N-1] = 1;
        for(int i=1;i<N;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int curr =1; 
        int sum= Math.max(1, left[N-1]);
        for(int i=N-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                curr++;
            }else{
                curr = 1;
            }
            sum += Math.max(curr,left[i]);
        }
        // int sum=0;
        // for(int i=0;i<N;i++){
        //     sum = sum +  Math.max(left[i], right[i]);
        // }
        return sum;
    }
}