class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new LinkedList<>();

        for (int a : asteroids) {
            if(a > 0){
                stack.addLast(a);
            }else{
                while (!stack.isEmpty() && stack.getLast() > 0 && stack.getLast() < Math.abs(a)) {
                    stack.removeLast();
                }

                if(!stack.isEmpty() && stack.getLast() == Math.abs(a)){
                    stack.removeLast();
                }else if(stack.isEmpty() || stack.getLast() <0){
                    stack.addLast(a);
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}