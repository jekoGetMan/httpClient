import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public final class HttpClientUtility {
    public static final String baseURI = "https://reqres.in/";
    private static CloseableHttpClient client = HttpClients.createDefault();

    private HttpClientUtility() {
    }

    public static String sendGet(String endpoint) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseURI + endpoint).setParameter("page", "2").build();
        HttpGet httpGet = new HttpGet(uri);

        return getResponse(client.execute(httpGet));
    }

    public static String sendPost(String endpoint, String jsonBody) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseURI + endpoint).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader("content-type", "application/json");
        StringEntity stringEntity = new StringEntity(jsonBody);
        httpPost.setEntity(stringEntity);

        return getResponse(client.execute(httpPost));
    }

    public static String getResponse(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        entity.writeTo(os);
        String content = os.toString();
        return content;
    }
}