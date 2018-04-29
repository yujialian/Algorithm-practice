public class denseGraph {
  int n, m;//n: Number of node, m: Number of points.
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
  public int V() {return n;}
  

}
