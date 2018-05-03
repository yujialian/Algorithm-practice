class Solution {
    Stack<Integer> stack;
    public boolean checkEqualTree(TreeNode root) {
        stack = new Stack<Integer>();
        int total = sum(root);
        stack.pop();
        if(total % 2 == 0) {
            for(int val : stack) {
                if(val == total / 2) return true;
            }
        } else {
            return false;
        }
        return false;
    }
    private int sum(TreeNode root) {
        if(root == null) return 0;
        stack.push(sum(root.left) + sum(root.right) + root.val);
        return stack.peek();
    }
}
