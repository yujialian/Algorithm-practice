/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode one = head, two = head;
        while(two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        two = one.next;
        one.next = null;
        one = head;
        two = reverse(two);
        ListNode ans = new ListNode(0);
        ListNode pointer = ans;
        while(one != null && two != null) {
            pointer.next = one;
            pointer = pointer.next;
            ListNode oneRemain = one.next;
            pointer.next = two;
            pointer = pointer.next;
            one = oneRemain;
            two = two.next;
        }
        if(one != null) {
            pointer.next = one;
        }
        head = ans.next;
    }
    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
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