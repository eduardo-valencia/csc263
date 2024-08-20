public class BinarySearchTree<Value> {
  Node<Value> mainNode = null;

  public void addValue(Comparable<Value> value) {
    Node<Value> newNode = new Node<Value>(value);
    if (this.mainNode)
      return this.mainNode.addNode(value);
    this.mainNode = newNode;
  }
}
