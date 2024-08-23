import java.awt.*;
import java.io.IOException;
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
    taskIds.add(1);
    taskIds.add(2);
    taskIds.add(3);
    return taskIds;
  }

  private void rescheduleTasks() throws Exception {
    this.showSection("Rescheduled Tasks");
    ArrayList<Integer> taskIds = this.getTaskIdsToReschedule();
    this.reschedulerService.rescheduleTasks(taskIds);
    System.out.println("\nTasks successfully rescheduled!\n");
    this.promptToContinue(null);
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

    if (tasks.isEmpty()) System.out.println("None");

    for (ToDoTask task : tasks) {
      this.logTask(task);
    }
  }

  private void logTasksForDate(LocalDate date) throws Exception {
    String formattedDate = this.formatDate(date);
    System.out.println("[" + formattedDate + "]:");
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

  private void showDivider() {
    System.out.println("------------------");
  }

  private void showSection(String title) {
    System.out.println("\n\n\n");
    this.showDivider();
    System.out.println(title);
    this.showDivider();
    System.out.println();
  }

  private void promptToContinue(String text) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(text == null ? "Press ENTER to continue.\n" : text);
    scanner.nextLine();
    System.out.println();
  }

  private void showTitleDivider() {
    System.out.println("--------------------------------");
  }

  private void showTitle() {
    this.showTitleDivider();
    System.out.println("Title: Enhanced Rescheduler");
    this.showTitleDivider();
    System.out.println();
  }

  private void showIntro() {
    this.showTitle();
    System.out.println(
            "This application allows you to reschedule today’s tasks automatically  This is useful if an unexpected" +
            "\n" +
            "event arises, and you need to postpone today’s tasks for another day.\n" +
            "\n" +
            "This program features intelligent task distribution. Instead of only rescheduling tasks for tomorrow,\ntasks are distributed across multiple days." +
            "\n\n" +
            "Specifically, the program will reschedule each task for the next non-busy day. A “non-busy day” is\ncurrently defined as a day with less than 3 tasks.\n" +
            "\n" +
            "Instructions:\n" +
            "\n" +
            "- Follow along with the application’s prompts.\n" +
            "- You can quit the application at any time by pressing CTRL + C." + "\n");
    this.promptToContinue("Press ENTER to see your list of tasks.");
  }

  private void showOriginalTasks() {
    this.showSection("Tasks");
    System.out.println("The following shows your list of tasks, grouped by day.\n");
    this.logTasksForDates();
    this.promptToContinue("Press ENTER to automatically reschedule these tasks for the next available day.");
  }

  private void showNewTasks() {
    this.showSection("Updated Tasks");
    System.out.println("The following shows the updated list of tasks.\n");
    this.logTasksForDates();
  }

  private void reset() throws Exception {
    this.taskService.resetTasks();
    this.taskService.generateBatch();
  }

  public void run() throws Exception {
    this.reset();
    this.showIntro();
    this.showOriginalTasks();
    this.rescheduleTasks();
    this.showNewTasks();
  }

  public static void main(String[] args) throws Exception {
    Final app = new Final();
    app.run();
  }
}
