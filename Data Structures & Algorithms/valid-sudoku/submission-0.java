class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];
                if (number != '.') {
                    int boxRow = r / 3;
                    int boxCol = c / 3;
                    if (!seen.add(number + " in row " + r) ||
                        !seen.add(number + " in column " + c) ||
                        !seen.add(number + " in box " + boxRow + "-" + boxCol)) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}
