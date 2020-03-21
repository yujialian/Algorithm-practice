public class unionFind {
  int[] parent;
  int count;
  public unionFind(int n) {
    count = n;
    parent = new int[n];
    for(int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  private int find(int p) {
    if(p >= 0 && p < n) {
      return parent[p];
    }
  }

  private boolean isConnected(int i, int j) {
    return find(parent[i]) ==find(parent[j]);
  }

  public void unionElements(int p, int q) {
    int pid = find(p);
    int qid = find(q);
    if(pid == qid) return;
    for(int i = 0; i < parent.length; i++) {
      if(parent[i] == pid) {
        parent[i] = qid;
      }
    }
  }
}
