class StockSpanner {

    // element, index
    Stack<int []> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }    
    public int next(int price) {
        index++;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int ans = index - ((stack.isEmpty()) ? -1 : stack.peek()[1]);

        stack.push(new int[]{price, index});

        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */