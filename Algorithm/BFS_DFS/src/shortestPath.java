public class shortestPath {//BFS
  public shortestPath (Graph graph, int s) {
    Graph G;
    int s;//startpoints
    boolean[] visited;//Record if the node is already visited during dfs process.
    int[] from; //Record route, from[i] represent current node's comming node.
    int[] ord; //Record the order of node
    public shortestPath(Graph graph, int s) {
      G = graph;
      assert s >= 0 && s < G.V();
      visited = new boolean[G.V()];
      from = new int[G.V()];
      ord = new int[G.V()];
      for(int i = 0; i < G.V(); i++) {
        visited[i] = false;
        from[i] = -1;
        ord[i] = -1;
      }
      this.s = s;
      List<Integer> q = new LinkedList<>();
      q.push(s);
      visited[s] = true;
      ord[s] = 0;
      while(!q.isEmpty()) {
        int v = q.pop();
        for(int i: G.adj(v)) {
          if(!visited[i]) {
            q.push(i);
            visited[i] = true;
            from[i] = v;
            ord[i] = ord[v] + 1;
          }
        }
      }
    }

  }
}
