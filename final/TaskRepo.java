import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskRepo extends TaskRepoAbstraction {


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

  public void writeTasks(ArrayList<ToDoTask> tasks) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = this.getFile();
    objectMapper.writeValue(file, tasks);
  }

  public void create(TaskCreationFields fields) throws Exception {
    ArrayList<ToDoTask> tasks = this.list();

    // TODO: maybe clone this
    fields.id = tasks.size();
    ToDoTask task = new ToDoTask(fields);

    tasks.add(task);

    this.writeTasks(tasks);
  }
}
