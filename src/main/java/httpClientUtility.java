import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public final class httpClientUtility {
    public static final String baseURI = "https://reqres.in/";
    private static HttpResponse response;

    public static void invokeHttpGet(String endpoint, CloseableHttpClient httpClient) throws IOException {
        HttpGet httpGet = new HttpGet(baseURI + endpoint);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse != null) {
            response = httpResponse;
        }
    }

    public static void invokeHttpPost(String endpoint, String jsonBody, CloseableHttpClient httpClient) throws IOException {
        HttpPost httpPost = new HttpPost(baseURI + endpoint);
        httpPost.setHeader("content-type", "application/json");
        StringEntity stringEntity = new StringEntity(jsonBody);
        httpPost.setEntity(stringEntity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse != null) {
            response = httpResponse;
        }
    }

    public static HttpResponse getResponse() {
        return response;
    }

    public static CloseableHttpClient getDefaultClient() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        return closeableHttpClient;
    }
}