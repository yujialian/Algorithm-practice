class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    private TreeNode build(int postE, int inS, int inE, int[] inorder, int[] postorder) {
        if(postE < 0 || postE > inorder.length - 1 || inS > inE) return null;
        //System.out.println(postE);
        TreeNode tn = new TreeNode(postorder[postE]);
        int index = inS;
        for(index = inS; index <= inE; index++) {
            if(inorder[index] == postorder[postE]) break;
        }
        tn.right = build(postE - 1, index + 1, inE, inorder, postorder);
        tn.left = build(postE - (inE - index) - 1, inS, index - 1, inorder, postorder);
        return tn;
    }
}
