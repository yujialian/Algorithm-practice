class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length -1, preorder, inorder);
    }
    private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(inStart > inEnd || preStart > preorder.length - 1) return null;
        int index = 0;
        TreeNode root = new TreeNode(preorder[preStart]);
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                index = i;
            }
        }
        root.left = build(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = build(preStart + (index - inStart) + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}
