class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, int start) {
        ans.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
