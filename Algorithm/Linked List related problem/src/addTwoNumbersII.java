class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode l1R = reverse(l1);
        ListNode l2R = reverse(l2);
        int jw = 0;
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while(l1R != null && l2R != null) {
            jw += l1R.val + l2R.val;
            //pointer.next = new ListNode(jw%10);
            l1R.val = jw%10;
            pointer.next = l1R;
            
            pointer.next.val = jw%10;
            jw = jw / 10;
            pointer = pointer.next;
            l1R = l1R.next;
            l2R = l2R.next;
        }
        while(l1R != null) {
            jw += l1R.val;
            //pointer.next = new ListNode(jw%10);
            l1R.val = jw%10;
            pointer.next = l1R;
            
            jw = jw / 10;
            pointer = pointer.next;
            l1R = l1R.next;
        }
        while(l2R != null) {
            jw += l2R.val;
            //pointer.next = new ListNode(jw%10);
            l2R.val = jw%10;
            pointer.next = l2R;
            
            jw = jw / 10;
            pointer = pointer.next;
            l2R = l2R.next;
        }
        if(jw != 0) {
            pointer.next = new ListNode(jw);
        }
        ListNode answer = res.next;
        return reverse(answer);
    }
    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev= null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}