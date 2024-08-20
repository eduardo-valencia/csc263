public class BinarySearchTree<Value extends Comparable<Value>> {
  /**
   * The root
   */
  Node<Value> mainNode = null;

  /**
   * Adds a value to the tree
   */
  public void addValue(Value value) {
    /**
     * We create a node with the value
     */
    Node<Value> newNode = new Node<Value>(value);

    /**
     * Adds a node with the value to the mainNode
     */
    if (this.mainNode != null)
      this.mainNode.addNode(newNode);
    /**
     * If the mainNode is null, we can just set it to a node with the value
     */
    else
      this.mainNode = newNode;
  }

  /**
   * Finds a value in the tree. Returns the node with the value.
   */
  public Node<Value> find(Value value) {
    Node<Value> nodeToSearch = this.mainNode;

    /**
     * While there are still nodes to search
     */
    while (nodeToSearch != null) {
      /**
       * Get the difference
       */
      int diff = value.compareTo(nodeToSearch.value);

      /**
       * If we found a match, return the found node
       */
      if (diff == 0)
        return nodeToSearch;
      /**
       * If the value is less than the node's value, continue searching in left
       */
      else if (diff < 0)
        nodeToSearch = nodeToSearch.leftNode;
      /**
       * If the value is > than the node's value, continue searching in right
       */
      else
        nodeToSearch = nodeToSearch.rightNode;
    }

    return null;
  }

  /**
   * Prints either the left node's value or the right node's value
   */
  private void printNodeSide(Node<Value> node, String side) {
    String valueToPrint = "null";
    if (node != null)
      valueToPrint = node.value.toString();
    System.out.println(side + ": " + valueToPrint);
  }

  /**
   * Recursively prints a node's values, given a starting node
   */
  private void printFromNode(Node<Value> node) {
    if (node == null)
      return;

    /**
     * Shows node's info
     */
    System.out.println("Value: " + node.value.toString());
    this.printNodeSide(node.leftNode, "Left");
    this.printNodeSide(node.rightNode, "Right");
    System.out.println("");

    /**
     * Shows the info of the left and right nodes
     */
    this.printFromNode(node.leftNode);
    this.printFromNode(node.rightNode);
  }

  /**
   * Shows the tree's nodes
   */
  public void showValues() {
    this.printFromNode(mainNode);
  }
}
