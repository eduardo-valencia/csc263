import java.util.HashSet;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    /**
     * We add an item and verify that the Hash Set stored it
     */
    private void addItemAndVerifyItExists() {
        HashSet<String> hashSet = new Assignment_3_2_Main().hashSet;
        String value = "value";
        hashSet.add(value);
        assertTrue(hashSet.contains(value));
    }

    /**
     * We test adding items
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It inserts items")
    public void add() {
        this.addItemAndVerifyItExists();
    }

    /**
     * We test that "contains" returns false if an item doesn't exist
     */
    private void verifyItemDoesNotExist() {
        HashSet<String> hashSet = new Assignment_3_2_Main().hashSet;
        assertFalse(hashSet.contains("unknown item"));
    }

    /**
     * We test that "contains" returns true or false under the right circumstances
     */
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("It returns whether an item is in the HashSet")
    public void contains() {
        this.addItemAndVerifyItExists();
        this.verifyItemDoesNotExist();
    }
}