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
    private ListNode reverse(ListNode begin, ListNode end) {
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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k) {//find the k+1 node
            curr = curr.next;
            count++;
        }
        if(count == k) {// if k+1 node is found
            curr = reverseKGroup(curr, k);// reverse list with k+1 node as head
            while(count > 0) {// reverse current k-group: 
                count--;
                ListNode temp = head.next;// tmp - next head in direct part
                head.next = curr;// preappending "direct" head to the reversed list 
                curr = head;// move head of reversed part to a new node
                head = temp;// move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}