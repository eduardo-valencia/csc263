public class BinarySearchTree<Value extends Comparable<Value>> {
  Node<Value> mainNode = null;

  public void addValue(Value value) {
    Node<Value> newNode = new Node<Value>(value);
    if (this.mainNode != null)
      this.mainNode.addNode(newNode);
    else
      this.mainNode = newNode;
  }
}
