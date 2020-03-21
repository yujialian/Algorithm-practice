public class SparseGraph {
  int n;//Number of points
  int m;//Number of edges
  boolean directed; //Is directed graph?
  Vector<Integer>[] g;//data in the graph
  public SparseGraph(int n, boolean directed) {
    assert n >= 0;
    this.n = n;
    this.m = 0;
    this.directed = directed;
    g = (Vector<Integer>[])new Vector[n];
    for(int i = 0; i < n; i++) {
      g[i] = new Vector<Integer>();
    }
  }
  public int V() { return n; };//Return number of vertices.
  public int E() { return m; };//Return number of edges.
  public void addEdge(int v, int w) {
    assert (v >= 0 && v < n);
    assert (w >= 0 && w < n);
    g[v].add(w);
    if(v != w && !directed) {
      g[w].add(v);
    }
    m++;
  }
  boolean hasEdge(int v, int w) {
    assert (v >= 0 && v < n);
    assert (w >= 0 && v < n);
    for(int i =0; i < g[v].size(); i++) {
      if(g[v].get(i) == w) return true;
    }
    return false;
  }
  public Iterable<Integer> adj(int v) {
    assert v >= 0 && v < n;
    return g[v];
  }
}
