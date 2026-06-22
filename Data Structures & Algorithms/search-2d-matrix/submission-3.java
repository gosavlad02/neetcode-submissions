class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = top + (bot - top) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            }
            else if (target < matrix[row][0]) {
                bot = row - 1;
            }
            else {
                break;
            }
        } // we identified the row, now we do a binary search in the row

        if (!(top <= bot)) {
            return false;
        }

        int low = 0, high = COLS - 1;
        int row = (top + bot) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < matrix[row][mid]) {
                high = mid - 1;
            }
            else if (target > matrix[row][mid]) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;


    }
}
