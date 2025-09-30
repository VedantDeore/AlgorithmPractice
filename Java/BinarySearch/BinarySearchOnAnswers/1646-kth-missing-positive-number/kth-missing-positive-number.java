class Solution {
    public int findKthPositive(int[] arr, int k) {
        int actual=1;
        int ans=-1;
        int i=0;
        while (k!=0) {
            if(i<arr.length){
            if(arr[i] == actual){
                i++;
                actual++;
            }else{
                k--;
                if(k==0){
                    ans = actual;   
                    break;  
                }
                actual++;
            }
            }else{
                break;
            }
        }
        if(k != 0){
            actual +=k;
            return actual -1;
        }
        return ans;
    }
}