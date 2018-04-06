class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(ans, new ArrayList<Integer>(), candidates, 0, target);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> list, int[] cd, int index, int target) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            if(list.size() >= 1) {
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = index; i < cd.length; i++) {
            list.add(cd[i]);
            dfs(ans, list, cd, i, target-cd[i]);
            list.remove(list.size() - 1);
        }
    }
}
