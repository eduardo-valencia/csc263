public class Assignment_5_2_Main {
  public static void main(String[] args) {
    System.out.println("Creating a thread!");

    Task task = new Task();
    Thread myThread = new Thread(task);
    myThread.start();
  }
}
