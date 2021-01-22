import java.io.IOException;

public class execute {
    public static void main(String[] args) throws IOException {
        httpClientUtility client = new httpClientUtility();
        System.out.println(client.invokeHttpGet("/api/users?page=2", client.getDefaultClient()));

//        String jsonBody = "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";
//
//        System.out.println(client.invokeHttpPost("/api/users", jsonBody, client.getDefaultClient()));
    }
}
