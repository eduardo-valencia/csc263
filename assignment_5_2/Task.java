public class Task implements Runnable {
  private void showCountUp() {
    int count = 0;

    while (count <= 20) {
      String name = Thread.currentThread().getName();
      System.out.println(name + ": " + count);
      count++;
    }
  }

  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("Running task in thread " + name + ". Beginning count to 20.\n");
    this.showCountUp();
  }
}
