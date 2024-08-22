import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class TaskService extends TaskServiceAbstraction {
    private final TaskRepo repo = new TaskRepo();

    @Override
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

    private ToDoTask getFromListById(ArrayList<ToDoTask> tasks, int id) throws Exception {
        for (ToDoTask task : tasks) {
            if (task.getId() == id) return task;
        }
        throw new Exception("Task " + id + " not found.");
    }

    private ArrayList<ToDoTask> updateTaskDueDateAndGetTasks(int id, LocalDate dueDate) throws Exception {
        ArrayList<ToDoTask> tasks = this.list();
        ToDoTask task = this.getFromListById(tasks, id);
        task.setDueDate(dueDate);
        return tasks;
    }

    @Override
    public void updateDueDate(int id, LocalDate dueDate) throws Exception {
        ArrayList<ToDoTask> tasks = this.updateTaskDueDateAndGetTasks(id, dueDate);
        this.repo.writeTasks(tasks);
    }

    public ToDoTask getById(int id) throws Exception {
        ArrayList<ToDoTask> tasks = this.list();
        return this.getFromListById(tasks, id);
    }

    public void resetTasks() throws IOException {
        ArrayList<ToDoTask> tasks = new ArrayList<>();
        this.repo.writeTasks(tasks);
    }

    private void generateForDate(LocalDate date, String name) throws Exception {
        TaskCreationFields fields = new TaskCreationFields();
        fields.name = name;
        fields.dueDate = date;
        this.repo.create(fields);
    }

    private void createTasksForDate(Iterator<LocalDate> iterator, String[] names) throws Exception {
        LocalDate date = iterator.next();

        for (String name : names) {
            this.generateForDate(date, name);
        }
    }

    private Stream<LocalDate> getDatesToGenTasksFor() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(3);
        return today.datesUntil(endDate);
    }

    public void generateBatch() throws Exception {
        Stream<LocalDate> dates = this.getDatesToGenTasksFor();
        Iterator<LocalDate> iterator = dates.iterator();

        this.createTasksForDate(iterator, new String[]{"Task 1", "Task 2", "Task 3"});
        this.createTasksForDate(iterator, new String[]{"Feed dogs"});
        this.createTasksForDate(iterator, new String[]{"Do homework", "Buy groceries", "Do work", "Run"});
    }
}
