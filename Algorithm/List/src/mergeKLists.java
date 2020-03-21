/*Version 1; Time exceeded.*/
public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) {
        return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode dummy1 = new ListNode(0);
    ListNode p = dummy1;
    ListNode merge2 = null;
    ListNode merge1 = null;
    for(int i = 0; i < lists.length; i++) {
        merge1 = lists[i];
        merge2 = dummy.next;
        p = dummy1;
        while(merge1 != null && merge2 != null) {
            if(merge1.val > merge2.val) {
                p.next = merge2;
                merge2 = merge2.next;
            } else {
                p.next = merge1;
                merge1 = merge1.next;
            }
            p = p.next;
        }
        if(merge1 != null) {
            p.next = merge1;
        }
        if(merge2 != null) {
            p.next = merge2;
        }
        dummy.next = dummy1.next;
    }
    return dummy.next;
}


//Improved merge sort.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }
    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if(lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid+1, hi);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if(l1 != null) {
            p.next = l1;
        }
        if(l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}