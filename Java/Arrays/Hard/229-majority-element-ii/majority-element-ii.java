class Solution {
    public List<Integer> majorityElement(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       for(Integer num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
       }
       List<Integer> ans = new ArrayList<>();
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        if(entry.getValue()> (nums.length/3)){
            ans.add(entry.getKey());
        }
       }
       return ans;
    }
}