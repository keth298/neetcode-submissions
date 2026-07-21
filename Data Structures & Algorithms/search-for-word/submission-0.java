class Solution {
    public boolean exist(char[][] board, String word) {
        List<Character> wordList = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backTrack(board, wordList, 0, r, c, set)) return true;
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, List<Character> word, int curr, int r, int c, Set<Integer> set) {
        if (curr == word.size()) return true;
        int rows = board.length, cols = board[0].length;
        int pos = r * cols + c;
        if (r < 0 || r >= rows || c < 0 || c >= cols || set.contains(pos) || board[r][c] != word.get(curr)) {
            return false;
        }


        set.add(pos);
        boolean found = backTrack(board, word, curr + 1, r + 1, c, set) ||
                        backTrack(board, word, curr + 1, r - 1, c, set) ||
                        backTrack(board, word, curr + 1, r, c + 1, set) ||
                        backTrack(board, word, curr + 1, r, c - 1, set);
        set.remove(pos);
        return found;
    }
}
