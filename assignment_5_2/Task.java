/**
 * A task that counts to 20.
 */
public class Task implements Runnable {
  /**
   * Counts up to 20
   */
  private void showCountUp() {
    int count = 0;

    while (count <= 20) {
      /**
       * Gets the thread's name
       */
      String name = Thread.currentThread().getName();
      /**
       * Shows the thread's name along with the current count to show what
       * thread the count belongs.
       */
      System.out.println(name + ": " + count);
      count++;
    }
  }

  /**
   * The starting point for the task.
   */
  public void run() {
    String name = Thread.currentThread().getName();
    /**
     * Shows that the thread started
     */
    System.out.println("Running task in thread " + name + ". Beginning count to 20.\n");
    /**
     * Starts counting up
     */
    this.showCountUp();
  }
}
