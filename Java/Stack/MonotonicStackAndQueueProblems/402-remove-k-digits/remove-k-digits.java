class Solution {
    public String removeKdigits(String num, int k) {
        if(k> num.length())return "0";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k>0 && !stack.isEmpty()) {
                stack.pop();
                k--;
        }

        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res = res.reverse();

        int start = 0;
        while (start < res.length() && res.charAt(start) == '0') {
            start++;
        }

        String ans = (start == res.length()) ? "0" : res.substring(start);
        return ans;
    }
}