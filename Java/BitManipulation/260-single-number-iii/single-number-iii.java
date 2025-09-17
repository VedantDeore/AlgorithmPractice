class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int n:nums){
            xor=xor^n;
        }
        int rightmost = (xor&xor-1)^(xor);
        int b1=0;
        int b2=0;
        for(int n:nums){
            if((rightmost&n)!=0){
                b1=b1^n;
            }else{
                b2=b2^n;
            }
        }
        return new int[]{b1,b2};
    }
}