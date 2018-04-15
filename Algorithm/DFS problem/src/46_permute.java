class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if(list.size() == nums.length) ans.add(new ArrayList<Integer>(list));
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
