class Solution {
    static {
    for(int i = 0; i < 500; i++) {
        characterReplacement("", 1);
    }
    }
    public static int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0, r=0, maxlen=0, maxf=0;
        int hash[] = new int[26];
        while(r<n){
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);
            if((r-l+1) - maxf >k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }
}