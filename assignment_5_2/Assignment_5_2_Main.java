public class Assignment_5_2_Main {
  private static void startThread() {
    Task task = new Task();
    Thread myThread = new Thread(task);
    myThread.start();
  }

  public static void main(String[] args) {
    System.out.println("Creating threads!\n");

    startThread();
    startThread();
  }
}
