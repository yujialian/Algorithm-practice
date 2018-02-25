/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) {
            return new ListNode(1);
        }
        ListNode reversed = reverse(head);
        ListNode pointer = new ListNode(0);
        pointer.next = reversed;
        int val = 1;
        while(val > 0) {
            if(pointer.next != null) {
                int total = pointer.next.val + val;
                if(total >= 10) {
                    pointer.next.val = total % 10;
                    val = total / 10;
                } else {
                    pointer.next.val = total;
                    break;
                }
                pointer = pointer.next;
            } else {
                pointer.next = new ListNode(val);
                break;
            }
        }
        return reverse(reversed);
            
    }
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

/*Plus one recursively.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if(DFS(head) == 0) {
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    private int DFS(ListNode head) {
        if(head == null) {
            return 1;
        }
        int carry = DFS(head.next);
        if(carry == 0) {
            return 0;
        }
        int total = (head.val + carry);
        head.val = total % 10;
        return total / 10;
}
}