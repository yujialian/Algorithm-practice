class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        LinkedList[] arr = new LinkedList[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < edges.length; i++) {
            arr[edges[i][0]].add(edges[i][1]);
            arr[edges[i][1]].add(edges[i][0]);
        }
        if(!dfs(arr, visited, 0, -1)) return false;
        for(boolean b: visited) if(!b) return false;
        return true;
    }
    private boolean dfs(LinkedList<Integer>[] arr, boolean[] visited, int i, int j) {
        visited[i] = true;
        for(int val: arr[i]) {
            if(val == j) continue;
            if(visited[val] == true || !dfs(arr, visited, val, i)) return false;
        }
        return true;
    }
}
