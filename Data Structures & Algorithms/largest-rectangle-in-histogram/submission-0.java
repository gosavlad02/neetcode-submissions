class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // (index, height)
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] bar : stack) {
            int index = bar[0];
            int height = bar[1];
            maxArea = Math.max(maxArea, (heights.length - index) * height);
        }
        return maxArea;
    }
}
