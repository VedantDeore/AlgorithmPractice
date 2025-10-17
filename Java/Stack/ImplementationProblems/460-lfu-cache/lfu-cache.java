class Node {
        int key;
        int data;
        int freq;
        Node next;
        Node prev;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.freq = 1;
        }
    }

class LFUCache {
        private final int capacity;
        private final Map<Integer, Node> nodeMap = new HashMap<>();
        private final Map<Integer, LinkedHashSet<Node>> freqMap = new HashMap<>();
        private int minFreq = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) return -1;

            Node node = nodeMap.get(key);
            updateFreq(node);
            return node.data;
        }

        public void put(int key, int val) {
            if (capacity == 0) return;

            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                node.data = val;
                updateFreq(node);
            } else {
                if (nodeMap.size() == capacity) {
                    // Remove least frequently used node
                    LinkedHashSet<Node> set = freqMap.get(minFreq);
                    Node lfuNode = set.iterator().next();
                    set.remove(lfuNode);
                    nodeMap.remove(lfuNode.key);
                }

                Node node = new Node(key, val);
                nodeMap.put(key, node);
                minFreq = 1;
                freqMap.computeIfAbsent(1, x -> new LinkedHashSet<>()).add(node);
            }
        }

        private void updateFreq(Node node) {
            int freq = node.freq;
            freqMap.get(freq).remove(node);

            if (freq == minFreq && freqMap.get(freq).isEmpty()) {
                minFreq++;
            }

            node.freq++;
            freqMap.computeIfAbsent(node.freq, x -> new LinkedHashSet<>()).add(node);
        }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */