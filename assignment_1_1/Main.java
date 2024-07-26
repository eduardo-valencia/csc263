import java.io.IOException;

public class Main extends MetaClass {
  public Main() {
    super("Main");
  }

  public static void main(String[] args) throws IOException {
    TaskRepo taskRepo = new TaskRepo();
    Task[] tasks = taskRepo.getTasks();

    for (int index = 0; index < tasks.length; index++) {
      Task task = tasks[index];
      System.out.println(task.name);
    }
  }
}