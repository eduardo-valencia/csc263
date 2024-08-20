public class Task implements Runnable {
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("Running task in thread " + name);
  }
}
