public class Assignment_5_1_Main {
  /**
   * Show that we can add values to the BST.
   */
  private static void testAdd() {
    System.out.println("The following shows adding values:");

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    /**
     * Add values to the BST
     */
    bst.addValue(3);
    bst.addValue(10);
    bst.addValue(8);

    /**
     * Show the BST's values
     */
    bst.showValues();

    System.out.println("------\n");
  }

  /**
   * Show finding a value in the BST
   */
  private static void testFind() {
    System.out.println("The following shows the result of finding the value 8:");

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    Integer lastValue = 8;
    /**
     * Add values to the BST
     */
    bst.addValue(1);
    bst.addValue(6);
    bst.addValue(lastValue);

    /**
     * Find the last value
     */
    Node<Integer> nodeWithValue = bst.find(lastValue);
    /**
     * Show the result of finding the value
     */

    if (nodeWithValue == null)
      System.out.println("Unable to find node");
    else {
      System.out.println("Successfully found a node with a value of " + nodeWithValue.value.toString() + ".");

    }
  }

  /**
   * This is the method that starts the program. It shows that we can add values
   * and find them in the BST.
   */
  public static void main(String[] args) {
    testAdd();
    testFind();
  }
}
