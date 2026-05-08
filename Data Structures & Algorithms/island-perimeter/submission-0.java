class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int perimeter = 0;

        for (int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){

                if(grid[r][c] == 1){
                    perimeter += 4;

                    if(r + 1 < row && grid[r + 1][c] == 1){
                        perimeter -= 2;
                    }
                    
                    if(c + 1 < col && grid[r][c + 1] == 1){
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}