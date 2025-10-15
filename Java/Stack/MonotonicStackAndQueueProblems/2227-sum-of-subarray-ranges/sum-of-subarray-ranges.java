
class SumOfSubarrayMinimum {
    public long sum(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0L;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            total += (long) arr[i] * left * right;
        }
        return total;
    }
}

class SumOfSubarrayMaximum {
    public long sum(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0L;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            total += (long) arr[i] * left * right;
        }
        return total;
    }
}

class Solution {
    public long subArrayRanges(int[] nums) {
        SumOfSubarrayMaximum maxCalc = new SumOfSubarrayMaximum();
        SumOfSubarrayMinimum minCalc = new SumOfSubarrayMinimum();
        return maxCalc.sum(nums) - minCalc.sum(nums);
    }
}
