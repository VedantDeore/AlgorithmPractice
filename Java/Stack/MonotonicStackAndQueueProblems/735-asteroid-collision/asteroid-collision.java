class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1; 

        for (int a : asteroids) {
            if (a > 0) {
                stack[++top] = a; 
            } else {    
                  
                while (top >= 0 && stack[top] > 0 && stack[top] < Math.abs(a)) {
                    top--; 
                }
                if (top >= 0 && stack[top] == Math.abs(a)) {
                    top--; 
                } else if (top == -1 || stack[top] < 0) {
                    stack[++top] = a; 
                }
                
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}