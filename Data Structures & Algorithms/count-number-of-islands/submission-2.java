class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(!(grid[r][c] == '0' || grid[r][c] == '#')){
                    hashOut(grid, r, c);
                    num++;
                }
            }
        }
        return num;
    }

    public void hashOut(char[][]grid, int r, int c){
        if(r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1) return;
        if(grid[r][c] == '0' || grid[r][c] == '#') return;
        if(grid[r][c] == '1') grid[r][c] = '#';
        hashOut(grid, r + 1, c);
        hashOut(grid, r - 1, c);
        hashOut(grid, r, c + 1);
        hashOut(grid, r, c - 1);
        return;
    }
}
