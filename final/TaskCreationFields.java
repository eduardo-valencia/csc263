import java.time.LocalDate;

public class TaskCreationFields {
    public int id;
    public String name;
    public LocalDate dueDate;
    public String dueDateString;

    public void validate() throws Exception {
        if (dueDate == null && dueDateString == null) throw new Exception("Invalid date");
        if (name == null) throw new Exception("Invalid name");
    }
}
