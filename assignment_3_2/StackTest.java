import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    /**
     * We test adding items
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It adds an item")
    public void push() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String value = "Value 1";
        main.stack.push(value);

        /**
         * We get the item at the top of the stack and test its value
         */
        assertEquals(main.stack.peek(), value);
    }

    /**
     * We test that peek returns the correct item
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It returns the first item")
    public void peek() {
        /**
         * We add items
         */
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String expectedValueAtTop = "Test";
        main.stack.push("Value 2");
        main.stack.push(expectedValueAtTop);

        /**
         * We get the item at the top of the stack and test its value
         */
        String topOfStack = main.stack.peek();
        assertEquals(topOfStack, expectedValueAtTop);
    }
}