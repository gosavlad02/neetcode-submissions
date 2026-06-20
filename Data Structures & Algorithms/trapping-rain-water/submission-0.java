class Solution {
    public int trap(int[] height) {
        // O(n) memory and time solution

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int totalWater = 0;
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = max;
            max = Math.max(height[i], max);
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(height[i], max);
        }

        for (int i = 0; i < height.length; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                totalWater += water;
            }
        }
        return totalWater;
    }
}
