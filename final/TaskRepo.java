import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class TaskRepo {
  private Stream<LocalDate> getDatesToGenTasksFor() {
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusDays(3);
    return today.datesUntil(endDate);
  }

  public ArrayList<ToDoTask> list() {
    return new ArrayList<ToDoTask>();
  }

  private void writeTasks(ArrayList<ToDoTask> tasks) {

  }

  private ToDoTask create(ToDoTask fields) {
    ArrayList<ToDoTask> tasks = this.list();

    Task task = fields.clone();
    task.id = tasks.length;

    tasks.push(task);

    this.writeTasks(tasks);

    return task;
  }

  private ToDoTask generateForDate(int index, LocalDate date) {
    ToDoTask fields = new ToDoTask();
    fields.name = "Task " + index;
    fields.dueDate = date;
    return this.create(fields);
  }

  private void createTasksForDate(Iterator<LocalDate> iterator, int index) {
    LocalDate date = iterator.next();
    int tasksToGenerate = 4 - index;
    for (int count = 0; count < tasksToGenerate; count++) {
      this.generateForDate(index, date);
    }
  }

  public void generateBatch() {
    Stream<LocalDate> dates = this.getDatesToGenTasksFor();
    Iterator<LocalDate> iterator = dates.iterator();
    int index = 0;

    while (iterator.hasNext()) {
      this.createTasksForDate(iterator, index);
      index++;
    }
  }
}
