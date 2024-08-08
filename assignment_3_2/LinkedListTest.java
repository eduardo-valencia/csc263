import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    @DisplayName("It inserts the node")
    void insertAtHead() {
        Node node = new Node("potato", null);
        LinkedList linkedList = new LinkedList(node);
        assertEquals(linkedList.node, node);
    }
}