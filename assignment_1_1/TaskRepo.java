import java.time.LocalDate;

public class TaskRepo extends MetaClass {
  public TaskRepo() {
    super("Task repo");
  }

  public Task[] getTasks() {
    Task task1 = new Task("Task 1", LocalDate.now());
    Task task2 = new Task("Task 2", LocalDate.now());
    Task[] tasks = { task1, task2 };
    return tasks;
  }

  private int getLowerLimit(int tasksLength, int limit) {
    if (tasksLength > limit)
      return limit;
    return tasksLength;
  }

  public Task[] getTasks(int limit) {
    Task[] allTasks = getTasks();
    int lowerLimit = getLowerLimit(allTasks.length, limit);

    Task[] tasks = new Task[lowerLimit];

    for (int index = 0; index < lowerLimit; index++) {
      tasks[index] = allTasks[index];
    }

    return tasks;
  }
}
