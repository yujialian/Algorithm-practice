class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums);
        dfs(nums, ans, new ArrayList<Integer>(), set);
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, Set<Integer> set) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(i) || (i > 0 && (nums[i] == nums[i - 1]) && !set.contains(i - 1))) {
                continue;
            }
            list.add(nums[i]);
            set.add(i);
            dfs(nums, ans, list, set);
            list.remove(list.size() -1);
            set.remove(i);
        }
    }
}
