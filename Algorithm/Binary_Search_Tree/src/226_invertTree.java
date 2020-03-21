class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
        return root;
    }
}

//Recursive
public TreeNode invertTree(TreeNode root) {
  if(root == null) return null;
  invertTree(root.left);
  invertTree(root.right);
  TreeNode tmp = root.left;
  root.left = root.right;
  root.right = tmp;
  return root;
}
