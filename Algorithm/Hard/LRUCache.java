//Naive LinkedHashMap method
class LRUCache {
    LinkedHashMap<Integer, Integer> linkedMap;
    final int capacity;
    public LRUCache(int capacity) {
        linkedMap = new LinkedHashMap<Integer, Integer>(capacity, (float)0.75, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return linkedMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        linkedMap.put(key, value);
    }
}

//Doubly Linked List method
class LRUCache {
    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public Node() {
            this(0, 0);
        }
    }
    Node head;
    Node tail;
    int count;
    final int CAP;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.CAP = capacity;
        this.count = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.get(key) == null) return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(node.key);
    }
    private void add(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev= head;
        map.put(node.key, node);
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            remove(cur);
            add(cur);
            return;
        }
        Node newNode = new Node(key, value);
        add(newNode);
        count++;
        if(count > CAP) {
            remove(tail.prev);
            count--;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
