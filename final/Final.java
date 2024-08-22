import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

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
    System.out.println();
  }

  private void promptToContinue() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Press ENTER to continue.\n");
    scanner.nextLine();
    System.out.println();
  }

  private void logTask(ToDoTask task) {
    int id = task.getId();
    String name = task.getName();

    System.out.println("Task #" + id + " : " + name);
  }

  private String formatDate(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return date.format(formatter);
  }

  private void logTasks(LocalDate date) throws Exception {
    ArrayList<ToDoTask> tasks = this.taskService.list(date);
    for (ToDoTask task : tasks) {
      this.logTask(task);
    }
  }

  private void logTasksForDate(LocalDate date) throws Exception {
    String formattedDate = this.formatDate(date);
    System.out.println("Date: " + formattedDate);
    this.logTasks(date);
    System.out.println();
  }

  private void logTasksForDates() {
    Stream<LocalDate> dates = this.taskService.getDatesToGenTasksFor();
    dates.forEach(date -> {
        try {
            logTasksForDate(date);
        } catch (Exception e) {
              throw new RuntimeException(e);
        }
    });
  }

  public void run() throws Exception {
    this.taskService.resetTasks();
    this.taskService.generateBatch();
    this.rescheduleTasks();
    this.logTasksForDates();
  }

  public static void main(String[] args) throws Exception {
    Final app = new Final();
    app.run();
  }
}
