import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TaskRepo {
  public String getTask() throws IOException {
    URL url = new URL("https://api.todoist.com/rest/v2/tasks");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    InputStream inputStream = connection.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    StringBuilder responseBuilder = new StringBuilder();

    String responseLine = bufferedReader.readLine();
    while (responseLine != null) {
      responseBuilder.append(responseLine);
      responseBuilder.append('\r');
    }

    bufferedReader.close();
    return responseBuilder.toString();
  }
}
