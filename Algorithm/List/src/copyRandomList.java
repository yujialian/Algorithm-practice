/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pointer = head;
        while(pointer != null) {
            map.put(pointer, new RandomListNode(pointer.label));
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer != null) {
            map.get(pointer).next = map.get(pointer.next);
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer != null) {
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }
        return map.get(head);
    }
}