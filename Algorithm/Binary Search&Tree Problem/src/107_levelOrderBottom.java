class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, root, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, TreeNode root, int level) {
        if(root == null) return;
        if(ans.size() == level) {
            ans.add(0, new LinkedList<Integer>());
        }
        ans.get(ans.size() - level - 1).add(root.val);
        dfs(ans, root.left, level+1);
        dfs(ans, root.right, level+1);
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            ans.add(0, list);
        }
        return ans;
    }
}
