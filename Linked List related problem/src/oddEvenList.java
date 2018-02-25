//My own, not that beautiful through
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = new ListNode(0);
        odd.next = head;
        ListNode even = new ListNode(0);
        even.next = head.next;
        
        ListNode p_odd = odd.next;
        ListNode p_even = even.next;
        while(p_odd != null && p_even != null) {
            if(p_odd.next != null) {
                p_odd.next = p_odd.next.next;
                p_odd = p_odd.next;
            }
            if(p_even.next != null) {
                p_even.next = p_even.next.next;
                p_even = p_even.next;
            }
        }
        
        if(p_odd != null) {
            p_odd.next = even.next;
        } else {
            ListNode pointer = odd;
            while(pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = even.next;
        }
        return odd.next;
    }
}


//Find it in discussion board, much clear
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

