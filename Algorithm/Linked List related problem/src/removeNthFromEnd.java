//My solution takes 2 pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pointer = head;
        while(pointer != null) {
            length++;
            pointer = pointer.next;
        }
        if(length < n) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        dummy.next = head;
        int curr = 0;
        while(curr < (length-n)) {
            p = p.next;
            curr++;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
//Look up the discussion board, see what other talent people do in one pass, why they so damn smart?
