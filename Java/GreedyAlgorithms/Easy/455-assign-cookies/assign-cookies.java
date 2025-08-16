class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        int n = greed.length;
        int m = cookieSize.length;

        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l = 0;      
        int r = 0;
        while (l < m && r < n) {           
            if (greed[r] <= cookieSize[l]) {                
                r++;
            }            
            l++;
        }
        return r;
    }
}