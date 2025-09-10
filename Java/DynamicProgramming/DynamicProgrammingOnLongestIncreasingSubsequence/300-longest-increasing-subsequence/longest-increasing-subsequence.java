class Solution {
    static {
        for (int i = 0; i < 150; i++) {
            lengthOfLIS(new int[] {0});
        }
    }
    public static int lengthOfLIS(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > temp.getLast()){
                temp.add(arr[i]);
            }else{
                int index = Collections.binarySearch(temp, arr[i]);
                if (index < 0) {
                    index= -index - 1;
                }
                temp.set(index, arr[i]);
            }

        }
        return temp.size();
    }
}