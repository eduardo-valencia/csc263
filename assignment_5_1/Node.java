public class Node<Value> {
  public Comparable<Value> value;
  public Node<Comparable<Value>> leftNode;
  public Node<Comparable<Value>> rightNode;

  public Node(Comparable<Value> value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  private void addNodeToLeft(Node<Comparable<Value>> insertee) {
    // TODO: Check this if/else statement works
    if (this.leftNode != null)
      this.leftNode.addNode(insertee);
    else
      this.leftNode = insertee;
  }

  private void addNodeToRight(Node<Comparable<Value>> insertee) {
    if (this.rightNode != null)
      this.rightNode.addNode(insertee);
    else
      this.rightNode = insertee;
  }

  public void addNode(Node<Comparable<Value>> insertee) {
    int diff = insertee.value.compareTo(this.value);
    if (diff < 0)
      this.addNodeToLeft(insertee);
  }
}
