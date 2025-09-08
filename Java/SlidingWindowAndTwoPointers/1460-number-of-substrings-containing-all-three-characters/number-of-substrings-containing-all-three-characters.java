class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int lastseen[] = {-1, -1, -1};
        int maxcnt=0;
        for(int i=0;i<n;i++){
            lastseen[s.charAt(i)-'a'] = i;
            int minIndex = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
            maxcnt += (minIndex + 1);
        }
        return maxcnt;
    }
}