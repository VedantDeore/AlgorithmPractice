class Solution {
    public void recursion(int i, int [] nums, ArrayList<Integer> temp,List<List<Integer>> ans){
        if(i ==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // take 
        temp.add(nums[i]);
        recursion(i+1,nums,temp,ans);
        temp.remove(temp.size() - 1);
        // not take
        recursion(i+1,nums,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
     recursion(0, nums, new ArrayList<>(), ans);
     return ans;
    }
}