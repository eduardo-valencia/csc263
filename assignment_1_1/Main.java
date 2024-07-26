import java.io.IOException;

public class Main extends MetaClass {
  public Main() {
    super("Main");
  }

  private static void showTasks(Task[] tasks) {
    System.out.println("Tasks:");
    for (int index = 0; index < tasks.length; index++) {
      Task task = tasks[index];
      System.out.println(task.name);
    }
    System.out.println("\n");
  }

  private static void showClass(MetaClass classInstance) {
    System.out.println("Class name: " + classInstance.displayName);
  }

  private static void showAFewClassNames(TaskRepo taskRepo, Task[] tasks) {
    System.out.println("Classes:");
    showClass(tasks[0]);
    showClass(taskRepo);
  }

  public static void main(String[] args) throws IOException {
    TaskRepo taskRepo = new TaskRepo();

    Task[] tasks = taskRepo.getTasks();
    showTasks(tasks);

    Task[] tasksWithLimit = taskRepo.getTasks(1);
    showTasks(tasksWithLimit);

    showAFewClassNames(taskRepo, tasks);
  }
}