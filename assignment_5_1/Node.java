public class Node<Value extends Comparable<Value>> {
  public Value value;
  public Node<Value> leftNode;
  public Node<Value> rightNode;

  public Node(Value value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  private void addNodeToLeft(Node<Value> insertee) {
    // TODO: Check this if/else statement works
    if (this.leftNode != null)
      this.leftNode.addNode(insertee);
    else
      this.leftNode = insertee;
  }

  private void addNodeToRight(Node<Value> insertee) {
    if (this.rightNode != null)
      this.rightNode.addNode(insertee);
    else
      this.rightNode = insertee;
  }

  public void addNode(Node<Value> insertee) {
    int diff = insertee.value.compareTo(this.value);
    if (diff < 0)
      this.addNodeToLeft(insertee);
    else
      // TODO: Is this what should happen if the values are equal?
      this.addNodeToRight(insertee);
  }
}
