import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskService extends TaskServiceAbstraction {
    private TaskRepo repo = new TaskRepo();

    public ArrayList<ToDoTask> list() throws Exception {
        return this.repo.list();
    }

    private void addTaskIfHasDueDate(LocalDate dueDate, ArrayList<ToDoTask> filteredTasks, Iterator<ToDoTask> iterator) {
        ToDoTask task = iterator.next();
        LocalDate taskDueDate = task.parseDueDate();
        if (taskDueDate.isEqual(dueDate)) filteredTasks.add(task);
    }

    public ArrayList<ToDoTask> list(LocalDate dueDate) throws Exception {
        ArrayList<ToDoTask> tasks = this.list();
        ArrayList<ToDoTask> filteredTasks = new ArrayList<>();

        Iterator<ToDoTask> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            this.addTaskIfHasDueDate(dueDate, filteredTasks, iterator);
        }

        return filteredTasks;
    }

    private ToDoTask getById(ArrayList<ToDoTask> tasks, int id) throws Exception {
        for (ToDoTask task : tasks) {
            if (task.getId() == id) return task;
        }
        throw new Exception("Task " + id + " not found.");
    }

    private ArrayList<ToDoTask> updateTaskDueDateAndGetTasks(int id, LocalDate dueDate) throws Exception {
        ArrayList<ToDoTask> tasks = this.list();
        ToDoTask task = this.getById(tasks, id);
        task.setDueDate(dueDate);
        return tasks;
    }

    public void updateDueDate(int id, LocalDate dueDate) throws Exception {
        ArrayList<ToDoTask> tasks = this.updateTaskDueDateAndGetTasks(id, dueDate);
        this.repo.writeTasks(tasks);
    }
}
