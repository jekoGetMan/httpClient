import java.io.IOException;

public class execute {
    public static void main(String[] args) throws IOException {
        httpClient client = new httpClient();
        System.out.println(client.invokeHttpGet("http://jsonplaceholder.typicode.com/posts"));
    }
}
