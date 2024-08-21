import java.io.File;
import java.io.IOException;
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
  public ArrayList<ToDoTask> list() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    InputStream inputStream = ArrayList.class.getResourceAsStream("./tasks.json");
    return (ArrayList<ToDoTask>) objectMapper.readValue(inputStream, ArrayList.class);
  }

  private void writeTasks(ArrayList<ToDoTask> tasks) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("./tasks.json");
    objectMapper.writeValue(file, tasks);
  }

  private void create(ToDoTask fields) throws IOException {
    ArrayList<ToDoTask> tasks = this.list();

    ToDoTask task = fields.clone();
    task.id = tasks.size();

    tasks.add(task);

    this.writeTasks(tasks);
  }

  private void generateForDate(int index, LocalDate date) throws IOException {
    ToDoTask fields = new ToDoTask();
    fields.name = "Task " + index;
    fields.setDueDate(date);
    this.create(fields);
  }

  private void createTasksForDate(Iterator<LocalDate> iterator, int index) throws IOException {
    LocalDate date = iterator.next();
    int tasksToGenerate = 4 - index;
    for (int count = 0; count < tasksToGenerate; count++) {
      this.generateForDate(index, date);
    }
  }

  public void generateBatch() throws IOException {
    Stream<LocalDate> dates = this.getDatesToGenTasksFor();
    Iterator<LocalDate> iterator = dates.iterator();
    int index = 0;

    while (iterator.hasNext()) {
      this.createTasksForDate(iterator, index);
      index++;
    }
  }
}
