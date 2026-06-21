class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] positionAndSpeed = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            positionAndSpeed[i][0] = position[i];
            positionAndSpeed[i][1] = speed[i];
        }
        Arrays.sort(positionAndSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] pair : positionAndSpeed) {
            stack.push((double) (target - pair[0]) / pair[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }
}
