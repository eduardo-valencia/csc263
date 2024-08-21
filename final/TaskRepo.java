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

  private ArrayList<ToDoTask> list() {
    return new ArrayList<ToDoTask>();
  }

  private ToDoTask create(ToDoTask fields) {
    ArrayList<ToDoTask> tasks = this.list();
    return fields;
  }

  private ToDoTask generate() {
    ToDoTask task = new ToDoTask();
    task.id = 
  }

  private ArrayList<ToDoTask> createTasksForDate(Iterator<LocalDate> iterator, int index) {
    LocalDate date = iterator.next();
    int tasksToGenerate = 4 - index;
    for (int count = 0; count < tasksToGenerate; count++) {

    }
  }

  private ArrayList<ToDoTask> generateBatch() {
    Stream<LocalDate> dates = this.getDatesToGenTasksFor();
    Iterator<LocalDate> iterator = dates.iterator();

    int index = 0;
    while (iterator.hasNext()) {
      index++;
    }
  }
}
