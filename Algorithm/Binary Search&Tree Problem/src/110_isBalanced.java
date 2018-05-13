class Solution {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return result;
    }
    private int depth(TreeNode root) {
        if(!result) return 0;
        if(root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if(Math.abs(l - r) > 1) result = false;
        return 1 + Math.max(l, r);
    }
}
