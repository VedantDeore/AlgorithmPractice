class Solution {
    private int[] nse(int arr[]){
        int n = arr.length;
        int nse[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }
    private int[] psee(int arr[]){
        int n = arr.length;
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int[] next = nse(arr);
        int[] prev = psee(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = (long) (i - prev[i]);
            long right = (long) (next[i] - i);
            long contribution = (arr[i] * left % mod) * right % mod;
            total = (total + contribution) % mod;
        }

        return (int) total;
    }
}