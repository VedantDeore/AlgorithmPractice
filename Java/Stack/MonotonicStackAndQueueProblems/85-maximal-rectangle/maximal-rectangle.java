class Solution {
    public int LargestRectangleInHistogram(int arr[]){
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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int prefixSum[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum += (matrix[i][j] -'0');
                if(matrix[i][j] == '0'){
                    sum=0;
                }

                prefixSum[i][j] = sum;
            }
        }

        int maxArea=0;
        for (int[] arr : prefixSum) {
            maxArea = Math.max(maxArea, LargestRectangleInHistogram(arr));
        }
        return maxArea; 
    }
}