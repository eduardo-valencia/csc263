import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDoTask {
  public int id;
  public String name;

  public String dueDateString;

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public LocalDate getDueDate() {
    if (dueDateString == null) return null;
    return LocalDate.parse(this.dueDateString, formatter);
  }

  public void setDueDate(LocalDate newDueDate) {
    this.dueDateString = formatter.format(newDueDate);
  }

  public ToDoTask clone() {
    ToDoTask task = new ToDoTask();
    task.id = this.id;
    task.name = this.name;

    LocalDate dueDate = task.getDueDate();
    task.setDueDate(dueDate);

    return task;
  }
}
