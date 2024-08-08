import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts the node")
    void insertAtHead() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String value = "Test";
        main.linkedList.push(value);
        String firstNode = main.linkedList.getFirst();
        assertEquals(firstNode, value);
    }
}