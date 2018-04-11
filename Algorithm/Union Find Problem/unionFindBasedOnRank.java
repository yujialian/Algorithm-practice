//recommanded
public class unionFindBasedOnRank {
  int[] rank;
  int[] parent;
  public unionFindBasedOnRank(int n) {
    parent = new int[n];
    rank = new int[n];
    for(int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }
  public boolean isConnected(int i, int j) {
    return find(i) == find(j);
  }
  public int find(int i) {
    while(i != parent[i]) {
      i = parent[i];
    }
    return i;
  }
  public void union(int i, int j) {
    int indexi = find(i);
    int indexj = find(j);
    if(indexi == indexj) return;
    if(rank[indexi] > rank[indexj]) {
      parent[indexj] = indexi;
    } else if(rank[indexi] < rank[indexj]) {
      parent[indexi] = indexj;
    } else {
      parent[indexi] = indexj;
      rank[indexj] += 1;
    }
  }
}
