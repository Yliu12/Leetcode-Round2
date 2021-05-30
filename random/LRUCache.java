package random;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> nodeMap;
    int count;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node n = nodeMap.get(key);
            moveToHead(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node n;
        if (nodeMap.containsKey(key)) {
            n = nodeMap.get(key);
            n.value = value;
            count--;
        } else {
            n = new Node(key, value);
            nodeMap.put(key, n);
        }
        if (count == capacity) {
            nodeMap.remove(tail.key);
            if(tail.previous!= null) tail = tail.previous;
            count--;
        }
        if (head == null) {
            head = n;
            tail = n;
        } else {
            moveToHead(n);
        }
        count++;
    }

    private void moveToHead(Node newHead) {
        if(head == newHead) return;
        Node newHeadPrev = newHead.previous;
        if(newHeadPrev!= null){
            newHeadPrev.next = newHead.next;
            newHead.previous = null;
        }
        if(newHead.next != null){
            newHead.next.previous = newHeadPrev;
        }
        head.previous = newHead;
        newHead.next = head;
        head = newHead;
        if (tail == newHead) {
            tail = newHeadPrev;
        }
    }

    public class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node previous;
        public Node next;
        public int key;
        public int value;
    }

    public static void main(String[] args) {
        // LRUCache lRUCache = new LRUCache(3);
        // lRUCache.put(1, 1); // cache is {1=1}
        // lRUCache.put(2, 2); // cache is {1=1, 2=2}
        // lRUCache.put(3, 3 ); // cache is {1=1, 2=2}
        // lRUCache.put(4, 4); // cache is {1=1, 2=2}
        // lRUCache.get(4);
        // lRUCache.get(3);
        // lRUCache.get(2);
        // lRUCache.get(1);
        // lRUCache.put(5, 5); 
        // lRUCache.get(1);
        // lRUCache.get(2);
        // lRUCache.get(3);
        // lRUCache.get(4);
        // lRUCache.get(5);

        // LRUCache lRUCache = new LRUCache(1);       
        // lRUCache.put(2, 1); // cache is {1=1, 2=2}
        // lRUCache.get(2);
        // lRUCache.put(3, 2); // cache is {1=1, 2=2}
        // lRUCache.get(2);
        // lRUCache.get(3);

        LRUCache lRUCache = new LRUCache(2);       
        lRUCache.put(2, 1); // cache is {1=1, 2=2}
        lRUCache.put(1, 1); // cache is {1=1, 2=2}
        lRUCache.put(2, 3); // cache is {1=1, 2=2}
        lRUCache.put(4, 1); // cache is {1=1, 2=2}
        lRUCache.get(1);
        lRUCache.get(2);
    }
}
