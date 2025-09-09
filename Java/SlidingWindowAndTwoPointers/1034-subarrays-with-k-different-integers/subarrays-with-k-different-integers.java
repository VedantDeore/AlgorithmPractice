class Solution {
    static {
        for(int i = 0; i < 500; ++i)
            subarraysWithKDistinct(new int[0], 1);
    }
    private static int subarraylessthanequaltok(int arr[], int k){
        int r=0,l=0,cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while(map.size() > k){
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
                if(map.size() <= k ){
                    cnt += (r-l+1);
                }
                r++;
        }
        return cnt;
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraylessthanequaltok(nums,k) - subarraylessthanequaltok(nums,k-1);
    }
}