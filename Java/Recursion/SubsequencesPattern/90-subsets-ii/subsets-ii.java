class Solution {
    private void findSubsets(int index, int arr[], List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));

        for(int i= index;i<arr.length;i++){
            if(i!=index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            findSubsets(i+1, arr,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
    }
}