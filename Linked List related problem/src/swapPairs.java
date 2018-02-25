//it's actally a bit of tricky, we can not use the second pointer to point the first because the part
//which after second pointer will be garbage collected, so we use one point the part after two, then
//two point back to one, pointer point to current next element, which is two, then move pointer to current
//index.
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode one = null;
        ListNode two = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer.next != null && pointer.next.next != null) {
            one = pointer.next;
            two = pointer.next.next;
            one.next = two.next;
            two.next = one;
            pointer.next = two;
            pointer = pointer.next.next;
        }
        return dummy.next;
    }
}