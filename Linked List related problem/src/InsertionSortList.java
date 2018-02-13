/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode ans = new ListNode(0);
        while(curr != null) {
            next = curr.next;
            ListNode dummy = ans;
            while(dummy.next != null && dummy.next.val < curr.val) {
                dummy = dummy.next;
            }
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return ans.next;
    }
}