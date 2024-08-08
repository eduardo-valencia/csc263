public class Main {
  public void showLinkedList() {

  }

  // TODO: Don't create any data structures until professor tells us what we
  // have to do.
  public static void main(String[] args) {
    Node node = new Node("potato", null);
    LinkedList linkedList = new LinkedList(node);

    System.out.println("head " + linkedList.head);
    System.out.println("head data " + linkedList.head.data);
  }

}
