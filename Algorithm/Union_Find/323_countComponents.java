class Solution {
    int size;
    int[] roots;
    int[] sz;
    public int countComponents(int n, int[][] edges) {
        if(n <= 1) {
            return n;
        }
        this.size = n;
        roots = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            roots[i] = i;
            sz[i] = 1;
        }
        for(int[] edge: edges) {
            if(!isConnect(edge[0], edge[1])) {
                connect(edge[0], edge[1]);
            }
        }
        return size;
    }
    private int find(int i) {
        while(i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
    private boolean isConnect(int i, int j) {
        int indexi = find(i);
        int indexj = find(j);
        return indexi == indexj;
    }
    private void connect(int i, int j) {
        int indexi = find(i);
        int indexj = find(j);
        if(indexi == indexj) return;
        size--;
        if(sz[indexi] > sz[indexj]) {
            roots[indexj] = indexi;
        } else if(sz[indexi] < sz[indexj]) {
            roots[indexi] = indexj;
        } else {
            roots[indexi] = indexj;
            sz[indexj] += 1;
        }
    }
    }
