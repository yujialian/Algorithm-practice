class Solution {
    int count = 0;
    int[] root;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        root = new int[m*n];
        int[][] matrix = new int[m][n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        for(int[] curArr: positions) {
            int x = curArr[0];
            int y = curArr[1];
            if(matrix[x][y] == 1) {
                ans.add(count);
                continue;
            }
            int cur = x*n+y;
            count++;
            matrix[x][y] = 1;
            if(x > 0 && matrix[x-1][y] > 0) {
                union(cur, cur-n);
            }
            if(x < m - 1 && matrix[x + 1][y] > 0) {
                union(cur, cur+n);
            }
            if(y > 0 && matrix[x][y - 1] > 0) {
                union(cur, cur-1);
            }
            if(y < n - 1 && matrix[x][y + 1] > 0) {
                union(cur, cur+1);
            }
            ans.add(count);
        }
        return ans;
    }
    
    
    private int find(int target) {
        while(target != root[target]) {
            root[target] = root[root[target]];
            target = root[target];
        }
        return target;
    }
    private void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);
        if(iroot != jroot) {
            root[iroot] = jroot;
            count--;
        }
        }
}