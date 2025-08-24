class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();

        int n = intervals.length;
        int i=0;
        while(i<n  && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
           newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
           newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
           i++;
        }
        res.add(new int[]{newInterval[0],newInterval[1]});
        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        int ans[][] = new int[res.size()][2];
        for(int j=0; j<ans.length; j++){
            ans[j][0] = res.get(j)[0];
            ans[j][1] = res.get(j)[1];
        }

        return ans;
    }
}