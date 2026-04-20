class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.tail = new ListNode(0);
        this.head = new ListNode(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode curr = map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr.next = this.head.next;
            curr.prev = this.head;
            this.head.next.prev = curr;
            this.head.next = curr;

            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        ListNode curr = null;
        if (map.containsKey(key)) {
            curr = map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        } else if (map.size() >= capacity) {
            curr = map.remove(this.tail.prev.key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        } 

        ListNode node = new ListNode(value, key);
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
        map.put(key, node);
    }
    
    public class ListNode {
        public int val;
        public int key;
        public ListNode next;
        public ListNode prev;
        
        public ListNode(int val) {
            this.val = val;
            ListNode next = null;
            ListNode prev = null;
        }

        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
            ListNode next = null;
            ListNode prev = null;
        }
    }
}
