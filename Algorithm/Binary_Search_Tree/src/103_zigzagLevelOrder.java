class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if((ans.size() - 1) % 2 == 1) list.add(queue.poll().val);
                else list.add(0, queue.poll().val);
            }
            ans.add(list);
        }
        return ans;
    }
}
