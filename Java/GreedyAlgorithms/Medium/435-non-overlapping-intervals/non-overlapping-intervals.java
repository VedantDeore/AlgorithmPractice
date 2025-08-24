class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Pair slots[] = new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++){
            slots[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(slots, (a,b)-> (a.second - b.second));
        
        int cnt=0;
        int freetime=Integer.MIN_VALUE;;
        for(int i=0;i< slots.length;i++){
            if(slots[i].first >= freetime){
                cnt++;
                freetime = slots[i].second;
            }
        }

        return slots.length - cnt;
    }
}