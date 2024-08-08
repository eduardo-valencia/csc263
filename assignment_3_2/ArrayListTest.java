import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    public void addItemsAndValidateLastOne() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();

        /**
         * We add items
         */
        String lastValue = "Value 1";
        main.arrayList.addLast("Value 2");
        main.arrayList.addLast(lastValue);

        /**
         * We test that the last item is the correct one
         */
        assertEquals(main.arrayList.getLast(), lastValue);
    }

    /**
     * Test adding an item
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts the item at the end")
    public void addLast() {
        this.addItemsAndValidateLastOne();
    }

    /**
     * Test getting the last item
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It gets the last item, even when there are multiple items")
    public void getLast() {
        this.addItemsAndValidateLastOne();
    }
}