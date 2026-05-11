class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxArea = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, row, col);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int row, int col) {
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        int down = dfs(grid, r + 1, c, row, col);
        int up = dfs(grid, r - 1, c, row, col);
        int right = dfs(grid, r, c + 1, row, col);
        int left = dfs(grid, r, c - 1, row, col);

        return 1 + down + up + right + left;
    }
}
