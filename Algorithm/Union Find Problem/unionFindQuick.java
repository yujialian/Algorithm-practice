public class unionFindQuick {
  int[] parent;
  public unionFindQuick(int n) {
    parent = new int[n];
    for(int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
  }
  public int find(int n) {
    if(n < 0 || n >= parent.length) return -1;
    while(n != parent[n]) {
      n = parent[n];
    }
    return n;
  }
  public boolean isConnected(int i, int j) {
    return find(i) == find(j);
  }
  public void union(int i, int j) {
    int findi = find(i);
    int findj = find(j);
    if(findi == findj) return;
    parent[findi] = findj;
  }
}
