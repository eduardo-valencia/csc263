import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskRepo extends TaskRepoAbstraction {
  private Stream<LocalDate> getDatesToGenTasksFor() {
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusDays(3);
    return today.datesUntil(endDate);
  }

  @Override
  public ArrayList<ToDoTask> list() {
    ObjectMapper objectMapper = new ObjectMapper();
    InputStream inputStream = ToDoTask.class.getResourceAsStream("./tasks.json");
    try {
      return (ArrayList<ToDoTask>) objectMapper.readValue(inputStream, ArrayList.class);
    } catch (Exception error) {
      System.err.println(error.toString());
      return new ArrayList<ToDoTask>();
    }
  }

  private void writeTasks(ArrayList<ToDoTask> tasks) {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("./tasks.json");
    try {
      objectMapper.writeValue(file, tasks);
    } catch (Exception error) {
      System.err.println(error.toString());
    }
  }

  private ToDoTask create(ToDoTask fields) {
    ArrayList<ToDoTask> tasks = this.list();

    ToDoTask task = fields.clone();
    task.id = tasks.size();

    tasks.add(task);

    this.writeTasks(tasks);

    return task;
  }

  private void generateForDate(int index, LocalDate date) {
    ToDoTask fields = new ToDoTask();
    fields.name = "Task " + index;
    fields.setDueDate(date);
    this.create(fields);
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
