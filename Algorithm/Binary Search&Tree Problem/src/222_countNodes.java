//Recursively: Time Limit Exceeded
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

class Solution {
    //一直向左下走来计算深度
    //如果左右子树深度相同，那么说明右子数是满二叉树，左子树是完全二叉树
    //否则说明左子树是满二叉树，右子树是完全二叉树
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode rightT = root.right;
        TreeNode leftT = root.left;
        int rDepth = getDepth(rightT);
        int lDepth = getDepth(leftT);
        if(rDepth == lDepth) return countNodes(rightT) + (1 << lDepth);
        else return countNodes(leftT) + (1 << rDepth);

    }
    private int getDepth(TreeNode node) {
        if(node == null) return 0;
        int depth = 1;
        while(node.left != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

}
