class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dequeue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if(!dequeue.isEmpty() && dequeue.getFirst() <= i-k) {
                dequeue.removeFirst();
            }

            while (!dequeue.isEmpty() && arr[dequeue.getLast()] <= arr[i]) {
                dequeue.removeLast();
            }
            dequeue.addLast(i);

            if(i>= k-1){
                list.add(arr[dequeue.getFirst()]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}