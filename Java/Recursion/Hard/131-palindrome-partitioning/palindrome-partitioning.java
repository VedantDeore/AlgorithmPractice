class Solution {
    private static boolean isPallindrome(String s,int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))return false;
        }
        return true;
    }
    private static void findCombos(int index, String s, List<List<String>> ans, List<String> ds){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPallindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                findCombos(i+1,s,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        findCombos(0,s,ans,new ArrayList<String>());
        return ans;
    }
}