import java.time.LocalDate;

public class TaskRepo {
  public Task[] getTasks() {
    Task task1 = new Task("Task 1", LocalDate.now());
    Task task2 = new Task("Task 2", LocalDate.now());
    Task[] tasks = { task1, task2 };
    return tasks;
  }
}
