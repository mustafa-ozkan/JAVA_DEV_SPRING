import linkedlistexamples.CyLinkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        var cyLinkedList = new CyLinkedList();
        cyLinkedList.addLast(1);
        cyLinkedList.addLast(2);
        cyLinkedList.addLast(3);
        cyLinkedList.printLinkedList();
        System.out.println();
        cyLinkedList.deleteLast();
        cyLinkedList.printLinkedList();

    }
}
