import java.time.LocalDate;
import java.util.ArrayList;

public abstract class TaskServiceAbstraction {
    public abstract ArrayList<ToDoTask> list() throws Exception;

    public abstract void updateDueDate(int id, LocalDate dueDate) throws Exception;
}
