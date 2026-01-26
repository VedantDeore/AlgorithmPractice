class Solution {
    private boolean all0(int arr[]){
        for(int x : arr){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if( s1.length() > s2.length()){
            return false;
        }
        int arr[] = new int[26];
        for(char c: s1.toCharArray()){
            arr[c - 'a']++;
        }
        int l=0;
        for(int r = 0 ; r< s2.length();r++){
            arr[s2.charAt(r) - 'a']--;

            if(r-l + 1 > s1.length()){
                arr[s2.charAt(l) - 'a']++;
                l++;
            }
            
            if(all0(arr)){
                return true;
            }
        }
        return false;
    }
}