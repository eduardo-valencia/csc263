import java.util.HashSet;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    private void addItemAndVerifyItExists() {
        HashSet<String> hashSet = new Assignment_3_2_Main().hashSet;
        String value = "value";
        hashSet.add(value);
        assertTrue(hashSet.contains(value));
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts items")
    public void add() {
        this.addItemAndVerifyItExists();
    }

    private void verifyItemDoesNotExist() {
        HashSet<String> hashSet = new Assignment_3_2_Main().hashSet;
        assertFalse(hashSet.contains("unknown item"));
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It returns whether an item is in the HashSet")
    public void contains() {
        this.addItemAndVerifyItExists();
        this.verifyItemDoesNotExist();
    }
}