import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskRepo extends TaskRepoAbstraction {
  private Stream<LocalDate> getDatesToGenTasksFor() {
    LocalDate today = LocalDate.now();
    LocalDate endDate = today.plusDays(3);
    return today.datesUntil(endDate);
  }

  private File getFile() {
    return new File("./tasks.json");
  }

  private ToDoTask createTaskInstanceFromFields(TaskCreationFields fields) throws Exception {
    return new ToDoTask(fields);
  }

  private ArrayList<ToDoTask> convertFieldsToTasks(ArrayList<TaskCreationFields> fieldsList) throws Exception {
    ArrayList<ToDoTask> tasks = new ArrayList<>();
    for (TaskCreationFields fields : fieldsList) {
        ToDoTask task = new ToDoTask(fields);
        tasks.add(task);
    }
    return tasks;
  }


  @Override
  public ArrayList<ToDoTask> list() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<ArrayList<TaskCreationFields>> typeRef = new TypeReference<>() {};
    File file = this.getFile();
    ArrayList<TaskCreationFields> fieldsList = objectMapper.readValue(file, typeRef);
    return this.convertFieldsToTasks(fieldsList);

  }

  private void writeTasks(ArrayList<ToDoTask> tasks) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = this.getFile();
    objectMapper.writeValue(file, tasks);
  }

  private void create(TaskCreationFields fields) throws Exception {
    ArrayList<ToDoTask> tasks = this.list();

    // TODO: maybe clone this
    fields.id = tasks.size();
    ToDoTask task = new ToDoTask(fields);

    tasks.add(task);

    this.writeTasks(tasks);
  }

  private void generateForDate(int index, LocalDate date) throws Exception {
    TaskCreationFields fields = new TaskCreationFields();
    fields.name = "Task " + index;
    fields.dueDate = date;
    this.create(fields);
  }

  private void createTasksForDate(Iterator<LocalDate> iterator, int index) throws Exception {
    LocalDate date = iterator.next();
    int tasksToGenerate = 4 - index;
    for (int count = 0; count < tasksToGenerate; count++) {
      this.generateForDate(index, date);
    }
  }

  public void generateBatch() throws Exception {
    Stream<LocalDate> dates = this.getDatesToGenTasksFor();
    Iterator<LocalDate> iterator = dates.iterator();
    int index = 0;

    while (iterator.hasNext()) {
      this.createTasksForDate(iterator, index);
      index++;
    }
  }
}
