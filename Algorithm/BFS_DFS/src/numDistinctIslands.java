class Solution {
    ArrayList<Integer> path;
    int[][] grid;
    boolean[][] mark;
    private void dfs(ArrayList<Integer> path, int i, int j, int pos) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && mark[i][j] == false) {
            mark[i][j] = true;
            path.add(pos);
            dfs(path, i+1, j, 1);
            dfs(path, i-1, j, 2);
            dfs(path, i, j-1, 3);
            dfs(path, i, j+1, 4);
            path.add(0);
        }
    }
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        mark = new boolean[grid.length][grid[0].length];
        Set<ArrayList<Integer>> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    path = new ArrayList<>();
                    dfs(path, i, j, 0);
                    if(!path.isEmpty()) {
                        set.add(path);
                    }
                }
            }
        }
        return set.size();
    }
}