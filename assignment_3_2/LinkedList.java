public class LinkedList {
  public Node head;

  public LinkedList(Node head) {
    this.head = head;
  }

  public void insertAtHead(Object element) {
    Node newHead = new Node(element, head);
    this.head = newHead;
  }

//  public void removeFirst
}
