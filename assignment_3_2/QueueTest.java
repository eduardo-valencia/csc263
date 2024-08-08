import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts the item at the end")
    public void add() {
        Queue<String> queue = new Assignment_3_2_Main().queue;
        String value = "value";
        queue.add(value);

        String head = queue.peek();
        assertEquals(head, value);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It removes the first item")
    public void remove() {
        Queue<String> queue = new Assignment_3_2_Main().queue;
        String value = "value";
        queue.add(value);
        queue.remove();

        String head = queue.peek();
        assertNull(head);
    }
}