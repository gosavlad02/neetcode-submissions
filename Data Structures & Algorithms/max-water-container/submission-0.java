class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max_area = 0;

        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]); //width * height
            if (heights[left] < heights[right]) {
                left++;
            }
            else if (heights[left] >= heights[right]) {
                right--;
            }
            max_area = Math.max(max_area, area);
        }

        return max_area;
    }
}
