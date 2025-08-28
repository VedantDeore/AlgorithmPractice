class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int front[] = new int[n];
        int idx=0;
        for(int element: triangle.get(n-1)){
            front[idx++] = element;
        }
        for(int i=n-2;i>=0;i--){
            int curr[] = new int[n];
            for(int j=i; j>=0; j--){
                int d = triangle.get(i).get(j) + front[j];
                int dg = triangle.get(i).get(j) + front[j+1];
                curr[j] = Math.min(d,dg);
            }
            front = curr;
        }
        return front[0];
    }
}