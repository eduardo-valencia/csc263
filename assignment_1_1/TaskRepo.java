import java.time.LocalDate;

/**
 * - Note how this class inherits from the MetaClass.
 * 
 * - This class shows that this program has encapsulation. This is
 * because it hides the functionality for getting tasks with a limit. For
 * example, it sets "getLowerLimit" to private. By doing so, we hide the
 * complexity of the program.
 */
public class TaskRepo extends MetaClass {
  public TaskRepo() {
    /**
     * Here, we set the display name.
     */
    super("Task repo");
  }

  /**
   * Defines the list of tasks and returns them.
   */
  public Task[] getTasks() {
    Task task1 = new Task("Task 1", LocalDate.now());
    Task task2 = new Task("Task 2", LocalDate.now());
    Task[] tasks = { task1, task2 };
    return tasks;
  }

  /**
   * Returns the maximum number of tasks we can actually return
   */
  private int getLowerLimit(int tasksLength, int limit) {
    if (tasksLength > limit)
      return limit;
    return tasksLength;
  }

  /**
   * This is an overload of the function "getTasks." This version of the
   * function allows us to limit the number of tasks we get.
   */
  public Task[] getTasks(int limit) {
    Task[] allTasks = getTasks();
    int lowerLimit = getLowerLimit(allTasks.length, limit);

    /**
     * Stores the tasks we will actually return
     */
    Task[] tasks = new Task[lowerLimit];

    /**
     * Sets each task
     */
    for (int index = 0; index < lowerLimit; index++) {
      tasks[index] = allTasks[index];
    }

    return tasks;
  }
}
