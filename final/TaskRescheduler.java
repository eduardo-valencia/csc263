import java.time.LocalDate;
import java.util.ArrayList;

public class TaskRescheduler {
    private final ToDoTask updatedTask;

    private final ToDoTask originalTask;

    private final TaskService service = new TaskService();

    public TaskRescheduler(ToDoTask task) throws Exception {
        this.updatedTask = task.cloneTask();
        this.originalTask = task.cloneTask();
    }

    private void continueTryingToReschedule(LocalDate date) throws Exception {
        LocalDate nextDate = date.plusDays(1);
        this.tryReschedulingTaskForDate(nextDate);
    }

    private void tryReschedulingTaskForDate(LocalDate date) throws Exception {
        ArrayList<ToDoTask> tasks = this.service.list(date);
        int MAX_TASKS_PER_DAY = 3;
        if (tasks.size() >= MAX_TASKS_PER_DAY) this.continueTryingToReschedule(date);
        else this.service.updateDueDate(this.updatedTask.getId(), date);
    }

    private void logTask() {
        String name = updatedTask.getName();
        String originalDueDate = originalTask.getDueDateString();
        System.out.println(name + " rescheduled from " + originalDueDate + " to " + updatedTask.getDueDateString());
    }

    // TODO: Make sure we call this with today + 1
    public void reschedule(LocalDate after) throws Exception {
        this.tryReschedulingTaskForDate(after);
        // TODO: Should we be updating by ref?
        this.logTask();
    }
}
