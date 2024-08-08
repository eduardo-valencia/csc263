import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts the item at the end")
    public void addLast() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String lastValue = "Value 1";
        main.arrayList.addLast("Value 2");
        main.arrayList.addLast(lastValue);

        assertEquals(main.arrayList.getLast(), lastValue);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It gets the last item, even when there are multiple items")
    public void getLast() {
        Assignment_3_2_Main main = new Assignment_3_2_Main();
        String lastValue = "Test";
        main.arrayList.addLast("Value 2");
        main.arrayList.addLast(lastValue);

        String lastNode = main.arrayList.getLast();
        assertEquals(lastNode, lastValue);
    }
}