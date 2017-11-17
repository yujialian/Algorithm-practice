//DFS
class Friend_Circle {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[M.length];
        int total = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(M,visited, i);
                total++;
            }
        }
        return total;
    }
    private void dfs(int[][] M, boolean[] visited, int person) {
        for(int other = 0; other < M.length; other++) {
            if(M[person][other] == 1 && !visited[other]) {
                visited[other] = true;
                dfs(M,visited, other);
            }
        }
    }
    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        Friend_Circle test = new Friend_Circle();
        System.out.println(test.findCircleNum(M));

    }
}