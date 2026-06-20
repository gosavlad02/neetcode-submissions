class Solution {
    public boolean isValidSudoku(char[][] board) {
    // These track if a number (0-8) has been seen in a specific row, col, or box
    boolean[][] seenInRow = new boolean[9][9];
    boolean[][] seenInCol = new boolean[9][9];
    boolean[][] seenInBox = new boolean[9][9];

    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') continue;

            // Convert char '1'-'9' into an integer index 0-8
            int val = board[r][c] - '1';
            
            // Map the current row and col to one of the 9 subboxes (0 to 8)
            int boxIdx = (r / 3) * 3 + (c / 3);

            // If it's already true, we found a duplicate
            if (seenInRow[r][val] || seenInCol[c][val] || seenInBox[boxIdx][val]) {
                return false;
            }

            // Mark this number as seen for future iterations
            seenInRow[r][val] = true;
            seenInCol[c][val] = true;
            seenInBox[boxIdx][val] = true;
        }
    }
    return true;
}
}
