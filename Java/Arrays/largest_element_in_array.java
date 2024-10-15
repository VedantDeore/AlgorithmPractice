class Solution {
    public static int largest(int[] arr) {
        // largest to store the element 
        int l = 0;
        for(int i:arr){
            if(i>l){
                l =i;
            }
        }
        return l;
    }
}
