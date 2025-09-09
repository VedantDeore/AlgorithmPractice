class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n)return "";

        int l=0;
        int r=0;
        int hash[] = new int[256];
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }

        int minlen=(int)1e9;
        int cnt=0;
        int startingIndex=-1;
        while(r<n){
            char rc = s.charAt(r);
            if(hash[rc] > 0){
                cnt++;
            }
            hash[rc]--;
            while(cnt == m){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    startingIndex=l;
                }
                
                char lc = s.charAt(l);
                hash[lc]++;
                if(hash[lc] > 0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return (startingIndex == -1)? "" : s.substring(startingIndex, startingIndex + minlen);
    }
}