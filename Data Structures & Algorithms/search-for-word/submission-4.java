class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtrack(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(
        int row, int col, char[][] board, String word, int idx, boolean[][] visited) {
        if (idx == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]
            || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = true;

        boolean found = backtrack(row + 1, col, board, word, idx + 1, visited) || // Down
            backtrack(row, col - 1, board, word, idx + 1, visited) || // Left
            backtrack(row, col + 1, board, word, idx + 1, visited) || // Right
            backtrack(row - 1, col, board, word, idx + 1, visited); // Up

        visited[row][col] = false;

        return found;
    }
}
