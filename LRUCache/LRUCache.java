import java.util.*;

public class LRUCache {
    private static class Node {
        public int key;
        public int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public Node head;
    public Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(); 
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        // check if key is valid, returns if not
        if (!this.map.containsKey(key)) {
            return -1;
        }

        // move the node to the tail (basically back of the queue)
        Node curr = this.map.get(key);
        this.remove(curr);
        this.append(curr);

        return curr.val;
    }
    
    public void put(int key, int value) {
        // check if key is already in map
        if (map.containsKey(key)) {
            // change the value of the node
            Node curr = map.get(key);
            curr.val = value;

            // move to end of list
            this.remove(curr);
            this.append(curr);
        } else {
            if (this.map.size() >= this.capacity) { //if we've run outta room
                // delete the head
                this.map.remove(this.head.key);
                this.remove(this.head);
            }
            // create a new node with vals
            Node curr = new Node(key, value);
            // add it to the map
            map.put(key, curr);
            // append it to end of list
            this.append(curr);

        }
    }
    
    private void remove(Node node) {
        // adjust the next field
        if (node.prev == null) { // check if node is head
            this.head = node.next;
        } else { 
            node.prev.next = node.next;
        }

        // adjust the prev field
        if (node.next == null) {
            this.tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    private void append(Node node) {
        // if there is a tail, fix it's next field
        if (tail != null) {
            this.tail.next = node;
        }

        // adjust fields, standard fare
        node.next = null;
        node.prev = this.tail;
        this.tail = node;
    
        // if this is the first node inserted,
        // then it's both head and tail
        if (head == null) {
            head = tail;
        }
    }

    public void print() {
       return; 
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int temp = cache.get(1);  
        // System.out.println(cache.head.key + " " + cache.tail.key);
        System.out.println(temp);
        cache.put(3,3);
        temp = cache.get(2);
        System.out.println(temp);
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
