import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Scanner;

public class execute {
    public static void main(String[] args) throws IOException {
        httpClientUtility client = new httpClientUtility();

        //GET
        client.invokeHttpGet("/api/users?page=2", client.getDefaultClient());
        HttpResponse httpResponse = client.getResponse();
        System.out.println("Status code ->" + httpResponse.getStatusLine().getStatusCode());

        //Print response
        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }

        //POST
        String jsonBody = "{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";
        client.invokeHttpPost("api/users", jsonBody, client.getDefaultClient());
        HttpResponse response = client.getResponse();
        System.out.println("Status code ->" + response.getStatusLine().getStatusCode());

        //Print response
        Scanner sc1 = new Scanner(response.getEntity().getContent());
        while (sc1.hasNext()) {
            System.out.println(sc1.next());
        }

    }
}
