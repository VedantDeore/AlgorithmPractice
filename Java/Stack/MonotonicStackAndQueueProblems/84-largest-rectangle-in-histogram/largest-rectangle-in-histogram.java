class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int element = stack.pop();
                int nse = i;
                int pse = (stack.isEmpty()) ? -1 : stack.peek();

                maxArea = Math.max(maxArea, (nse - pse -1)*arr[element]);
            }
            stack.push(i);
        }


         while (!stack.isEmpty()) {
                int element = stack.pop();
                int nse = arr.length;
                int pse = (stack.isEmpty()) ? -1 : stack.peek();

                maxArea = Math.max(maxArea, (nse - pse -1)*arr[element]);
        }
        return maxArea;
    }
}