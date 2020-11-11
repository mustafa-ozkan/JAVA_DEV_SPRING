package assignments;

import linkedlistexamples.CyLinkedList;

public class Assignment_003 {
    public static void main(String[] args) {
        var linkedList = new CyLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);


     linkedList.printLinkedList();
        linkedList.reverse();
        linkedList.printLinkedList();

    }

}
