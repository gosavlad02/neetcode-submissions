class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        // two pointers
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r]; 
        int totalWater = 0;


        while (l < r) {
            if (maxLeft <= maxRight) {
                totalWater += Math.max(0, maxLeft - height[l]);
                l++;
                maxLeft = Math.max(height[l], maxLeft);
            }
            else {
                totalWater += Math.max(0, maxRight - height[r]);
                r--;
                maxRight = Math.max(height[r], maxRight);
            }
        }
        return totalWater;
    }
}
