import java.time.LocalDate;

/**
 * This class stores info about a task.
 * 
 * Note how this class inherits from the MetaClass.
 */
class Task extends MetaClass {
  String name;
  LocalDate date;

  public Task(String _name, LocalDate _date) {
    /**
     * Here, we set the display name.
     */
    super("Task");
    name = _name;
    date = _date;
  }
}