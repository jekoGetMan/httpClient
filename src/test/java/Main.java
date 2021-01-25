import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String jsonBody = "{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";

        System.out.println("********************************************************");
        System.out.println(HttpClientUtility.sendGet("/api/users?page=2"));
        System.out.println("********************************************************");
        System.out.println(HttpClientUtility.sendPost("api/users", jsonBody));
        System.out.println("********************************************************");
    }
}