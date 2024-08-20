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

    while (nodeToSearch != null) {
      int diff = value.compareTo(nodeToSearch.value);
      if (diff == 0)
        return nodeToSearch;
      else if (diff < 0)
        nodeToSearch = nodeToSearch.leftNode;
      else
        nodeToSearch = nodeToSearch.rightNode;
    }

    return nodeToSearch;
  }

  private void printNodeSide(Node<Value> node, String side) {
    String valueToPrint = "null";
    if (node != null)
      valueToPrint = node.value.toString();
    System.out.println(side + ": " + valueToPrint);
  }

  private void printFromNode(Node<Value> node) {
    if (node == null)
      return;

    System.out.println("Value: " + node.value.toString());
    this.printNodeSide(node.leftNode, "Left");
    this.printNodeSide(node.rightNode, "Right");
    System.out.println("");

    this.printFromNode(node.leftNode);
    this.printFromNode(node.rightNode);
  }

  public void showValues() {
    this.printFromNode(mainNode);
  }
}
