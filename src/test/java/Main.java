import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String jsonBody = "{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";

        System.out.println("********************************************************");
        System.out.println(HttpClientUtility.sendGet("/api/users"));
        System.out.println("********************************************************");
        System.out.println(HttpClientUtility.sendPost("api/users", jsonBody));
        System.out.println("********************************************************");
    }
}