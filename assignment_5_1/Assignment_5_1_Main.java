public class Assignment_5_1_Main {
  private static void testAdd() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.addValue(3);
    bst.addValue(10);
    bst.addValue(8);

    bst.showValues();
  }

  private static void testFind() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    Integer lastValue = 8;
    bst.addValue(3);
    bst.addValue(10);
    bst.addValue(lastValue);

    Node<Integer> nodeWithValue = bst.find(lastValue);
    System.out.println("Value: " + nodeWithValue);
  }

  public static void main(String[] args) {
    testAdd();
    // testFind();
  }
}
