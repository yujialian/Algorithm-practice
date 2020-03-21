class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if(cur.right != null) {
                root = cur.right;
            }
        }
        return ans;
    }
}
