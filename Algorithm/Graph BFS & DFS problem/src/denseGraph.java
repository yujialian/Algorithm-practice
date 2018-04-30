public class denseGraph {
  int n, m;//n: Number of node, m: Number of edges.
  boolean directed;// Whether it's a directed graph.
  boolean[][] g;//
  public DenseGraph(int n, boolean directed) {
    if(n >= 0) {
      this.n = n;
      this.m = 0;
      this.directed = directed;
      g = new boolean[n][n];
    }
  }
  public int V() {return n;} //return number of vertices
  public int E() {return m;} //return number of edges

  public void addEdge(int v, int w) {
    assert(v >= 0 && v < n);
    assert(w >= 0 && w < n);
    if(hasEdge(v, w)) {
      return;
    }
    g[v][w] = true;
    if(!directed) {
      g[w][v] = true;
    }
    m++;
  }
  boolean hasEdge(int v, int w) {
    assert(v >= 0 && v < n);
    assert(w >= 0 && w < n);
    return g[v][w];
  }
  
  //Return certain versice's all adjacent edges.
  //Because of java's reference mechanism, return a vector does not take addtional space.
  public Iterable<Integer> adj(int v) {
    assert v >= 0 && v < n;
    Vector<Integer> adjV = new Vector<Integer>();
    for(int i = 0; i < n; i++) {
      if(g[v][i])
        adj.add(i);
    return adjV;
    }
  }
}
