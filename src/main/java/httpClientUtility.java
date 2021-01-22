import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class httpClientUtility {
    private static String baseURI = "http://reqres.in";
//    private static HttpClient httpClient = HttpClientBuilder.create().build();
//    private static final CloseableHttpClient client = HttpClients.createDefault();
//    CloseableHttpResponse response = client.execute(new HttpGet("https://4pda.ru/"));

    public static String invokeHttpGet(String endpoint, CloseableHttpClient httpClient) throws IOException {
        HttpGet httpGet = new HttpGet(baseURI + endpoint);
        return consumeResponse(httpClient.execute(httpGet));
    }

    public static String invokeHttpPost(String endpoint, String jsonData, CloseableHttpClient httpClient) throws IOException {
        HttpPost httpPost = new HttpPost(baseURI + endpoint);
        StringEntity entity = new StringEntity(jsonData);
        httpPost.setEntity(entity);
        return consumeResponse(httpClient.execute(httpPost));
    }

    public static String consumeResponse(HttpResponse response) throws IOException {
            int status = response.getStatusLine().getStatusCode();
            System.out.println(status);
            HttpEntity entity = response.getEntity();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        entity.writeTo(os);
        String content = os.toString("UTF-8");
        return content;
    }

    public static CloseableHttpClient getDefaultClient() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        return closeableHttpClient;
    }
}