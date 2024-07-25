import java.io.IOException;

public class Main extends MetaClass {
  public Main() {
    super("Main");
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Hello!");
    TaskRepo taskRepo = new TaskRepo();
    String response = taskRepo.getTask();
    System.out.println(response);
  }
}