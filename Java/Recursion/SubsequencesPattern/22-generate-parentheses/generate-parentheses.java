class Solution {
    public void backtrack(List<String> allcombos, String combo,int countOpen, int countClose, int n){
        if((countOpen == n) && (countClose == n)){
            allcombos.add(combo);
            return;
        }
        if(countOpen<n){
            backtrack(allcombos,combo + "(", countOpen+1,countClose,n);
        }
        if(countClose<countOpen){
             backtrack(allcombos,combo + ")", countOpen,countClose+1,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        String combo = "";
        List<String> allcombos = new ArrayList<String>();
        int countOpen = 0;
        int countClose = 0;
        backtrack(allcombos,combo,countOpen,countClose,n);
        return allcombos;
    }
}