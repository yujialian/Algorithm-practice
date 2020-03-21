public class unionFindBasedOnSize {
  int[] parent;
  int[] sz;
  public unionFindBasedOnSize(int n) {
    parent = new int[n];
    sz = new int[n];
    for(int i = 0; i < parent.length; i++) {
      parent[i] = i;
      sz = 1;
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
  public void connect(int i, int j) {
    int iindex = find(i);
    int jindex = find(j);
    if(iindex == jindex) return;
    if(sz[iindex] > sz[jindex]) {
      parent[jindex] = iindex;
      sz[iindex] += sz[jindex];
    } else {
      parent[iindex] = jindex;
      sz[jindex] += sz[iindex];
    }
  }
}
