class Solution {//
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode small = new ListNode(-1);
        ListNode smallP = small;
        ListNode large = new ListNode(-1);
        ListNode largeP = large;
        
        ListNode dumb = head;

        while(dumb != null) {
            if(dumb.val < x) {
                smallP.next = dumb;
                smallP = smallP.next;
            } else {
                largeP.next = dumb;
                largeP = largeP.next;
            }
            dumb = dumb.next;
            smallP.next = null;//Cut the circle
            largeP.next = null;
            
        }
        smallP.next = large.next;
        return small.next;
    }
}