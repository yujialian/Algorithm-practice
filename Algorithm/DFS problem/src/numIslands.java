class Solution {
    public int numIslands(char[][] grid) {
        int total = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    total += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return;
        }
        if(grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}