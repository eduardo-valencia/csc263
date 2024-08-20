public class BinarySearchTree<Value extends Comparable<Value>> {
  Node<Value> mainNode = null;

  public void addValue(Value value) {
    Node<Value> newNode = new Node<Value>(value);
    if (this.mainNode != null)
      this.mainNode.addNode(newNode);
    else
      this.mainNode = newNode;
  }

  public Node<Value> find(Value value) {
    Node<Value> nodeToSearch = new Node<Value>(value);

    while (nodeToSearch != null) {
      int diff = nodeToSearch.value.compareTo(value);
      if (diff == 0)
        return nodeToSearch;
      else if (diff < 0)
        nodeToSearch = nodeToSearch.leftNode;
      else
        nodeToSearch = nodeToSearch.rightNode;
    }

    return nodeToSearch;
  }

  private void printFromNode(Node<Value> node) {
    if (node == null)
      return;
    System.out.println("Value: " + node.value.toString());
    this.printFromNode(node.leftNode);
    this.printFromNode(node.rightNode);
  }

  public void showValues() {
    this.printFromNode(mainNode);
  }
}
