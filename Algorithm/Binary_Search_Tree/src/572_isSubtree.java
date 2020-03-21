class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s_string = inorder(s, false);
        String t_string = inorder(t, false);
        if(s_string.indexOf(t_string) != -1) return true;
        return false;
    }
    private String inorder(TreeNode node, boolean isLeft) {
        if(node == null) {
            if(isLeft == true) {
                return "true!";
            } else {
                return "false!";
            }
        }
        return inorder(node.left, true) + "#" + node.val + "#" + inorder(node.right, false);
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    private boolean traverse(TreeNode s, TreeNode t) {

        return (s != null) && (isEqual(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    private boolean isEqual(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        return (s.val == t.val) && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}
