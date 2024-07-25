import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TaskRepo {
  public String getTask() throws IOException {
    String filter = "!(@Routine) & !(no date) & !##Clients & !##Freelancing &  !##University & !(@Work)";
    // String filter = "today";
    String encodedFilter = URLEncoder.encode(filter, StandardCharsets.UTF_8.toString());

    URL url = new URL("https://api.todoist.com/rest/v2/tasks?filter=" + filter);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    String token = System.getenv("TODOIST_API_KEY");
    connection.setRequestProperty("Authorization", "Bearer " + token);

    InputStream inputStream = connection.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    StringBuilder responseBuilder = new StringBuilder();

    String responseLine = bufferedReader.readLine();
    while (responseLine != null) {
      responseBuilder.append(responseLine);
      responseBuilder.append('\r');
    }

    bufferedReader.close();
    connection.disconnect();
    return responseBuilder.toString();
  }
}
