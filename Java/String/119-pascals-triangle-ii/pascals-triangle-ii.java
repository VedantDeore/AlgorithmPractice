class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex == 0){
            res.add(1);
            return res;
        }
        res.add(1);
        long ans=1;
        for(int i=1;i<rowIndex;i++){
            ans= (ans*(rowIndex-i+1)/i);
            res.add((int)ans);
        }
        res.add(1);
        return res;
    }
}