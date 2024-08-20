public class Assignment_5_2_Main {
  /**
   * Starts a thread
   */
  private static void startThread() {
    /**
     * Creates a task
     */
    Task task = new Task();
    /**
     * Creates a thread
     */
    Thread myThread = new Thread(task);
    /**
     * Starts the thread
     */
    myThread.start();
  }

  /**
   * The program's starting point
   */
  public static void main(String[] args) {
    System.out.println("Creating threads!\n");

    /**
     * Starts multiple threads to show that threads can run simultaneously
     */
    startThread();
    startThread();
  }
}
