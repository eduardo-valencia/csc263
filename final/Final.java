import java.io.IOException;
import java.util.ArrayList;

public class Final {
  private final TaskService taskService = new TaskService();

  private final ReschedulerService reschedulerService = new ReschedulerService();

  private ArrayList<Integer> getTaskIdsToReschedule() {
    ArrayList<Integer> taskIds = new ArrayList<>();
    taskIds.add(0);
    taskIds.add(1);
    taskIds.add(2);
    return taskIds;
  }

  private void rescheduleTasks() throws Exception {
    ArrayList<Integer> taskIds = this.getTaskIdsToReschedule();
    this.reschedulerService.rescheduleTasks(taskIds);
  }

  public void run() throws Exception {
    this.taskService.resetTasks();
    this.taskService.generateBatch();
    this.rescheduleTasks();
  }

  public static void main(String[] args) throws Exception {
    Final app = new Final();
    app.run();
  }
}
