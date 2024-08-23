import java.time.LocalDate;
import java.util.ArrayList;

public class ReschedulerService {
    private final TaskService service = new TaskService();

    private void rescheduleTask(int taskId) throws Exception {
        ToDoTask task = this.service.getById(taskId);
        TaskRescheduler rescheduler = new TaskRescheduler(task);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        rescheduler.reschedule(tomorrow);
    }

    public void rescheduleTasks(ArrayList<Integer> taskIds) throws Exception {
        for (int taskId : taskIds) {
            this.rescheduleTask(taskId);
        }
    }
}
