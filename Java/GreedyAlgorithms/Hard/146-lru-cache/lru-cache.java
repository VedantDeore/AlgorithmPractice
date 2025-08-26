class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;       
        map.clear();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    private void insertAfterHead(Node node){
        Node currentAfterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currentAfterHead;
        currentAfterHead.prev = node;
    }
    private void deleteNode(Node node){
        Node afterNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size() == capacity){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */