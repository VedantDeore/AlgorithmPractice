class Solution {
    public List<Integer> generateRows(int rownumber){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int ans=1;
        // i is column
        for(int i=1;i<rownumber;i++){
            ans = ans *(rownumber-i);
            ans = ans/i;
            row.add(ans);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<= numRows;i++){
            ans.add(generateRows(i));
        }
        return ans;
    }
}