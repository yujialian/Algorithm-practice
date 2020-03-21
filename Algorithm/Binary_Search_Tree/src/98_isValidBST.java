class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean check(TreeNode root, long max, long min) {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return check(root.left, root.val, min) && check(root.right, max, root.val);
        }
}
