import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class httpClient {

        private static HttpClient httpClient = HttpClientBuilder.create().build();
//    private static final CloseableHttpClient client = HttpClients.createDefault();
//    CloseableHttpResponse response = client.execute(new HttpGet("https://4pda.ru/"));

        public static String invokeHttpGet(String url) throws IOException {
                HttpGet httpGet = new HttpGet(url);
                return consumeResponse(httpClient.execute(httpGet));
        }

        public static String consumeResponse(HttpResponse response) throws IOException {
                HttpEntity entity = response.getEntity();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                entity.writeTo(os);
                String content = os.toString("UTF-8");
                return content;
        }
}