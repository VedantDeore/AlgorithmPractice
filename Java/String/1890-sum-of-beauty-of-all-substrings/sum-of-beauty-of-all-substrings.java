class Solution {
    public int beautySum(String s) {
        int sum=0;
        String sub = ""; 
        for (int i = 0; i < s.length(); i++) {
            int [] table = new int[26];
            for (int j = i; j < s.length(); j++) {
                table[s.charAt(j) - 'a']++; 
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int element : table) {
                if (element > 0) {
                    maxFreq = Math.max(maxFreq, element);
                    minFreq = Math.min(minFreq, element);
                }
                }
                sum += (maxFreq - minFreq);
            }
            
        }
        return sum;
    }
}