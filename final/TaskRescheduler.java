import java.time.LocalDate;
import java.util.ArrayList;

public class TaskRescheduler {

    private final ToDoTask originalTask;

    private final TaskService service = new TaskService();

    public TaskRescheduler(ToDoTask task) throws Exception {
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
        else this.service.updateDueDate(this.originalTask.getId(), date);
    }

    private void logTask() throws Exception {
        ToDoTask updatedTask = this.service.getById(this.originalTask.getId());
        String name = updatedTask.getName();
        String originalDueDate = originalTask.getDueDateString();
        String newDueDate = updatedTask.getDueDateString();
        System.out.println(name + " rescheduled from " + originalDueDate + " to " + newDueDate);
    }

    public void reschedule(LocalDate dateToTryReschedulingFor) throws Exception {
        this.tryReschedulingTaskForDate(dateToTryReschedulingFor);
        // TODO: Should we be updating by ref?
        this.logTask();
    }
}
