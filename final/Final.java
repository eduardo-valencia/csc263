import java.io.IOException;

public class Final {
  public static void main(String[] args) throws Exception {
    TaskRepo repo = new TaskRepo();
    repo.generateBatch();
    repo.list();
  }
}
