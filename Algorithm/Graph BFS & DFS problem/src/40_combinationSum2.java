class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, ans, new ArrayList<Integer>(), target, 0);
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, int target, int start) {
        if(target < 0) return;
        if(target == 0) {
            ans.add(new ArrayList<Integer>(list));
        }
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, ans, list, target - nums[i], i+1);
            list.remove(list.size() - 1);
        }
    }
}
