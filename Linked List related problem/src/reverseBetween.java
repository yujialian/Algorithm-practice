class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode pointer1 = dumb;
        int start = 1;
        while(start != m) {
            pointer1 = pointer1.next;
            start++;
        }
        ListNode pointer2 = head;
        int end = 0;
        while(end != n) {
            pointer2 = pointer2.next;
            end++;
        }
        pointer1 = reverse(pointer1, pointer2);
        return dumb.next;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode initial = curr;
        ListNode prev = end;
        ListNode next = null;
        while(curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next = prev;
        initial.next = curr;
        return start;
    }
}