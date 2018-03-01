class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode point = head;
        while(point != null) {
            point = point.next;
            length++;
        }
        if(k > length) {
            k = k % length;
        }
        int remain = length - k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        point = dummy;
        int idx = 0;
        while(idx != remain) {
            idx++;
            point = point.next;
        }
        ListNode remainode = point.next;
        point.next = null;
        ListNode starter = new ListNode(0);
        starter.next = remainode;
        point = starter;
        while(point.next != null) {
            point = point.next;
        }
        point.next = dummy.next;
        return starter.next;
        
    }
}