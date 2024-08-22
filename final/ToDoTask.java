import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDoTask {
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private final int id;

  public int getId() {
    return this.id;
  }

  private final String name;

  public String getName() {
    return this.name;
  }

  private String dueDateString;

  private String getDueDateString(TaskCreationFields fields) {
    if (fields.dueDate != null) return formatter.format(fields.dueDate);
    return fields.dueDateString;
  }

  public ToDoTask(TaskCreationFields fields) throws Exception {
    fields.validate();
    this.id = fields.id;
    this.name = fields.name;
    this.dueDateString = this.getDueDateString(fields);
  }

  public LocalDate getDueDate() {
    return LocalDate.parse(this.dueDateString, formatter);
  }

  public void setDueDate(LocalDate newDueDate) throws Exception {
    if (newDueDate == null) throw new Exception("Invalid new due date");
    this.dueDateString = formatter.format(newDueDate);
  }

  public ToDoTask cloneTask() throws Exception {
    TaskCreationFields fields = new TaskCreationFields();
    fields.id = this.id;
    fields.name = this.name;
    fields.dueDate = this.getDueDate();

    return new ToDoTask(fields);
  }
}
