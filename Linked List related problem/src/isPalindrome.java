/*O(N) space version.*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        int length = 0;
        ListNode p = new ListNode(0);
        p.next = head;
        ArrayList<Integer> arrList = new ArrayList<>();
        while(p.next != null) {
            arrList.add(p.next.val);
            length++;
            p = p.next;
        }
        /*Reverse the list*/
        ListNode current = head;
        ListNode reverse= null;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }
        /*End of reverse.*/
        ListNode p2 = reverse;
        for(int i = 0; i < length/2; i++) {
            if(arrList.get(i) != p2.val) {
                return false;
            }
            //p1 = p1.next;
            p2 = p2.next;
        }
        return true;
        }
    }


//Improved, o(1) memory, o(n) time complexity.
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = null;
        if(fast == null) {//even
            secondHalf = slow;
        } else {//odd
            secondHalf = slow.next;
        }
        
        /*Reverse*/
        ListNode current = secondHalf;
        ListNode next = null;
        ListNode prev = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        /*End of reverse*/
        
        while(prev != null && head != null) {
            if(prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
        }
    }