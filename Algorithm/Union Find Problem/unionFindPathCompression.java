public class unionFindPathCompression {
  int[] parent;
  int[] rank;
  public unionFindPathCompression(int n) {
    parent = new int[n];
  }
  public boolean isConnected(int i, int j) {
    return find(i) == find(j);
  }
  public int find(int i) {
    if(i < 0 || i >= n) return -1;
    while(i != parent[i]) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }
  public int improvedFind(int i) {
    if(i < 0 || i >= n) return -1;
    if(i != parent[i]) {
      parent[i] = improvedFind(parent[i]);
    }
    return parent[i];
  }
  public void union(int p, int q) {
    int pindex = find(p);
    int qindex = find(q);
    if(pindex == qindex) return;
    if(rank[pindex] > rank[qindex]) {
      parent[qindex] = pindex;
    } else if(rank[qindex] > rank[pindex]) {
      parent[pindex] = qindex;
    } else {
      parent[pindex] = qindex;
      rank[qindex] += 1;
    }
  }
}
