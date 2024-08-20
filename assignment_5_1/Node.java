/**
 * A data structure for storing the tree's values
 */
public class Node<Value extends Comparable<Value>> {
  public Value value;
  /**
   * Will have values less than the node's value
   */
  public Node<Value> leftNode;
  /**
   * Will have values > than the node's value
   */
  public Node<Value> rightNode;

  public Node(Value value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  /**
   * Adds a node to the left side of the tree
   */
  private void addNodeToLeft(Node<Value> insertee) {
    if (this.leftNode != null)
      this.leftNode.addNode(insertee);
    else
      this.leftNode = insertee;
  }

  /**
   * Adds a node to the right side of the tree
   */
  private void addNodeToRight(Node<Value> insertee) {
    if (this.rightNode != null)
      this.rightNode.addNode(insertee);
    else
      this.rightNode = insertee;
  }

  /**
   * Adds a node on either the left or right side. See the definitions of
   * "leftNode" and "rightNode" for more info.
   */
  public void addNode(Node<Value> insertee) {
    /**
     * Gets the diff
     */
    int diff = insertee.value.compareTo(this.value);

    /**
     * If the new value is less than the parent node's value, add to left
     */
    if (diff < 0)
      this.addNodeToLeft(insertee);
    else
      /**
       * Otherwise, add to right
       */
      this.addNodeToRight(insertee);
  }
}
