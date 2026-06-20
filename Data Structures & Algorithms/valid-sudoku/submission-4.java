class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                if (val == '.') {
                    continue;
                }
                
                // Calculate the unique coordinate for the current 3x3 box
                String squareKey = (r / 3) + "," + (c / 3);

                // Safely get or create the sets
                Set<Character> rowSet = rows.computeIfAbsent(r, k -> new HashSet<>());
                Set<Character> colSet = cols.computeIfAbsent(c, k -> new HashSet<>());
                Set<Character> squareSet = squares.computeIfAbsent(squareKey, k -> new HashSet<>());

                // Check for duplicates
                if (rowSet.contains(val) || colSet.contains(val) || squareSet.contains(val)) {
                    return false;
                }

                // Add the values
                rowSet.add(val);
                colSet.add(val);
                squareSet.add(val);
            }
        }
        return true;
    }
}