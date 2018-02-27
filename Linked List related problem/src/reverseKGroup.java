class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        int i = 0;
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode begin = dumb;
        //next = head;
        while(head != null) {
            i++;
            if(i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dumb.next;
    }
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while(curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;//make the previous part connect with the reversed part.
        first.next = curr;//make the tail of reversed part connect with the unprocessed part.
        return first;
    }
}