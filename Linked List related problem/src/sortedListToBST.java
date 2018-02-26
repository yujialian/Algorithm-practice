class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;
        
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode tn = new TreeNode(slow.val);
        tn.left = toBST(head, slow);
        tn.right = toBST(slow.next, tail);
        return tn;
    }
}