public class BSTIterator {
    TreeNode next;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.next = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while(next != null) {
            stack.push(next);
            next = next.left;
        }
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right != null) {
            next = cur.right;
        }
        return cur.val;
    }
}
