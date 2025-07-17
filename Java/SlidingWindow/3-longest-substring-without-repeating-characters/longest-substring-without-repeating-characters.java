class Solution {
    public int lengthOfLongestSubstring(String s) {
         int n = s.length();
        int max = 0;
        int left = 0;
        int[] last = new int[128];
        for (int r = 0; r < n; r++) {
            left = Math.max(left, last[s.charAt(r)]);
            max = Math.max(max, r - left + 1);
            last[s.charAt(r)] = r + 1;
        }
        return max;
    }
}