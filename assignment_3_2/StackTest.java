import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It adds an item")
    public void push() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String value = "Value 1";
        main.stack.push(value);

        assertEquals(main.stack.peek(), value);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It returns the first item")
    public void peek() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String expectedValueAtTop = "Test";
        main.stack.push("Value 2");
        main.stack.push(expectedValueAtTop);

        String topOfStack = main.stack.peek();
        assertEquals(topOfStack, expectedValueAtTop);
    }
}