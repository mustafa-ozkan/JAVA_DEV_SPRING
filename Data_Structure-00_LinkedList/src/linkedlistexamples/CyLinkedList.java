package linkedlistexamples;

public class CyLinkedList {
    public class Node {
        public int value;
        public CyLinkedList next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    public int size;

    public CyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
}
