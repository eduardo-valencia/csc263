import java.time.LocalDate;
import java.util.Iterator;
import java.util.stream.Stream;

public class TaskFactory {
  private Stream<LocalDate> getDatesToGenTasksFor() {
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusDays(3);
    return today.datesUntil(endDate);
  }

  private ToDoTask generate() {
    ToDoTask task = new ToDoTask();
    task.id = 
  }

  private ToDoTask[] createTasksForDate(Iterator<LocalDate> iterator, int index) {
    LocalDate date = iterator.next();
    int tasksToGenerate = 4 - index;
    for (int count = 0; count < tasksToGenerate; count++) {

    }
  }

  private ToDoTask[] generateBatch() {
    Stream<LocalDate> dates = this.getDatesToGenTasksFor();
    Iterator<LocalDate> iterator = dates.iterator();

    int index = 0;
    while (iterator.hasNext()) {
      index++;
    }
  }
}
