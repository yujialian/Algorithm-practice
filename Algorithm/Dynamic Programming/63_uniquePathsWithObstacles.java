class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        boolean hasOne = false;
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                hasOne = true;
                grid[i][0] = 0;
            } else if(hasOne) {
                grid[i][0] = 0;
            } else {
                grid[i][0] = 1;
            }
        }
        hasOne = false;
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                hasOne = true;
                grid[0][i] = 0;
            } else if(hasOne) {
                grid[0][i] = 0;
            } else {
                grid[0][i] = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
