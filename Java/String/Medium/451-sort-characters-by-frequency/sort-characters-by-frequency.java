class Solution {
    public static int findMaxIndex(int [] arr){
        int maxi=0;
        int maxc=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxc){
                maxi=i;
                maxc= arr[i];
            }
        }
        return maxi;
    }
    public String frequencySort(String s) {
        int chars[] = new int[128];
        for(char ch: s.toCharArray() ){
            chars[ch]++;
        }
        char res[] = new char[s.length()];
        for(int i=0;i<s.length();){
            int maxi = findMaxIndex(chars);
            int freq = chars[maxi];
            while(freq>0){
                res[i++] = (char)(maxi);
                freq--;
            }
            chars[maxi]=0;
        }
        return new String(res);
    }
}