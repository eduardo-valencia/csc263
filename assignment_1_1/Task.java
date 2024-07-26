import java.time.LocalDate;

class Task extends MetaClass {
  String name;
  LocalDate date;

  public Task(String _name, LocalDate _date) {
    super("Task");
    name = _name;
    date = _date;
  }
}