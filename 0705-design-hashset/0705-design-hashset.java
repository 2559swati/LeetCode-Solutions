class MyHashSet {

    // Node stores only the key
    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    // Number of buckets
    private final int SIZE = 1000;

    // Array of linked lists
    private Node[] buckets;

    // Constructor
    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(int key) {
        return key % SIZE;
    }

    // ADD
    public void add(int key) {

        int index = getIndex(key);

        Node current = buckets[index];

        // Check if key already exists
        while (current != null) {

            if (current.key == key) {
                return;  // Already present
            }

            current = current.next;
        }

        // Key doesn't exist, create new node
        Node newNode = new Node(key);

        // Insert at beginning
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // REMOVE
    public void remove(int key) {

        int index = getIndex(key);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {

            if (current.key == key) {

                // Removing first node
                if (previous == null) {
                    buckets[index] = current.next;
                }

                // Removing middle/last node
                else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }

    // CONTAINS
    public boolean contains(int key) {

        int index = getIndex(key);

        Node current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */