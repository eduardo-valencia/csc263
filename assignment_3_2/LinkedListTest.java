import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts the item at the beginning")
    public void addFirst() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String value = "Test";
        main.linkedList.addFirst(value);
        String firstNode = main.linkedList.getFirst();
        assertEquals(firstNode, value);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It gets the first item, even when there are multiple items")
    public void getFirst() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String firstValue = "Test";
        main.linkedList.addFirst("Value 2");
        main.linkedList.addFirst(firstValue);

        String firstNode = main.linkedList.getFirst();
        assertEquals(firstNode, firstValue);
    }
}