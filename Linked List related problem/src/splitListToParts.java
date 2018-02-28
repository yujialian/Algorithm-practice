class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode point = root;
        while(point != null) {
            point = point.next;
            length++;
        }
        int NumEachEle = length / k;
        int remainEle = length % k;
        ListNode dummy = new ListNode(0);
        dummy.next = root;
        ListNode pointer = root;
        ArrayList<ListNode> arrList = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            int idx = NumEachEle;
            ListNode current = dummy;
            while(idx != 0) {
                current = current.next;
                idx--;   
            }
            
            if(remainEle != 0) {
                current = current.next;
                remainEle--;
            }
            
            ListNode remain = current.next;
            current.next = null;
            arrList.add(dummy.next);
            dummy.next = remain;
        }
        ListNode[] nodeList = new ListNode[arrList.size()];
        arrList.toArray(nodeList);
        return nodeList;
    }
}