import java.io.IOException;

/**
 * The class that starts the entire program.
 * 
 * - Note how this class inherits from the MetaClass.
 */
public class Main extends MetaClass {
  public Main() {
    /**
     * Here, we set the display name.
     */
    super("Main");
  }

  /**
   * Shows the tasks' names.
   */
  private static void showTasks(Task[] tasks) {
    for (int index = 0; index < tasks.length; index++) {
      Task task = tasks[index];
      System.out.println(task.name);
    }
    System.out.println("\n");
  }

  /**
   * Logs the name of a class.
   * 
   * This shows that the program uses polymorphism. By accepting a MetaClass, it
   * can accept every other class in the program. This means it can log any
   * class's name.
   */
  private static void showClassName(MetaClass classInstance) {
    System.out.println("Class name: " + classInstance.displayName);
  }

  /**
   * Shows the classes' names.
   */
  private static void showAFewClassNames(TaskRepo taskRepo, Task[] tasks) {
    System.out.println("The following are a few classes in this program:");
    showClassName(tasks[0]);
    showClassName(taskRepo);
  }

  /**
   * The main function that runs the program.
   */
  public static void main(String[] args) throws IOException {
    TaskRepo taskRepo = new TaskRepo();

    /**
     * Show all tasks.
     */
    System.out.println("All tasks:");
    Task[] tasks = taskRepo.getTasks();
    showTasks(tasks);

    /**
     * Show the first task.
     */
    System.out.println("The first task:");
    Task[] tasksWithLimit = taskRepo.getTasks(1);
    showTasks(tasksWithLimit);

    /**
     * Shows the names of a few classes.
     */
    showAFewClassNames(taskRepo, tasks);
  }
}