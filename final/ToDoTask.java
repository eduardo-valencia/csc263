import java.time.LocalDate;

public class ToDoTask {
  public int id;
  public String name;
  public LocalDate dueDate;

  public ToDoTask clone() {
    ToDoTask task = new ToDoTask();
    task.id = this.id;
    task.name = this.name;
    task.dueDate = this.dueDate;
    return task;
  }
}
