public class Assignment_5_1_Main {
  private static void testAdd() {
    System.out.println("The following shows adding values:");

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.addValue(3);
    bst.addValue(10);
    bst.addValue(8);

    bst.showValues();

    System.out.println("");
  }

  private static void testFind() {
    System.out.println("The following shows the result of finding the value 8:");

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    Integer lastValue = 8;
    bst.addValue(1);
    bst.addValue(6);
    bst.addValue(lastValue);

    Node<Integer> nodeWithValue = bst.find(lastValue);
    System.out.println("Successfully found a node with a value of " + nodeWithValue.value.toString() + ".");

    System.out.println("");
  }

  public static void main(String[] args) {
    testAdd();
    testFind();
  }
}
