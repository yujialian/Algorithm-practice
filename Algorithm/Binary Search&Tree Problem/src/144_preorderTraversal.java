class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if(cur.right != null) {
                root = cur.right;
            }
        }
        return ans;
    }
}
