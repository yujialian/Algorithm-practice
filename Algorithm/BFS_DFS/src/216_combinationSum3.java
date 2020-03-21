class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), n, k, 1);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> list, int n, int k, int start) {
        if(n == 0 && k == 0) {
            ans.add(new ArrayList<Integer>(list));
        } else if (n < 0 || k <= 0 || start > 9){
            return;
        } else {
            for(int i = start; i <= 9; i++) {
                list.add(i);
                dfs(ans, list, n - i, k - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
