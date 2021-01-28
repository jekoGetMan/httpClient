import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import response.GET.Get;
import response.POST.Post;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException, URISyntaxException {
        String jsonBody = "{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";

        Get gets = MAPPER.readValue(HttpClientUtility.sendGet("/api/users"), new TypeReference<Get>() {});

                                                                /*GET dto*/
        System.out.println("GET:");
        System.out.println("*******************************");
        System.out.println("\"page:\" " + gets.getPage());
        System.out.println("\"per_page:\" " + gets.getPer_page());
        System.out.println("\"total:\" " + gets.getTotal());
        System.out.println("\"total_pages:\" " + gets.getTotal_pages());
        System.out.println("*******************************");
        System.out.println("\"data\": [");
        System.out.println(gets.getData().get(0));
        System.out.println(gets.getData().get(1));
        System.out.println(gets.getData().get(2));
        System.out.println(gets.getData().get(3));
        System.out.println(gets.getData().get(4));
        System.out.println("*******************************");
        System.out.println("\"support\":");
        System.out.println("  \"url:\" " + gets.getSupport().getText());
        System.out.println("  \"text:\" " + gets.getSupport().getUrl());

        Post posts = MAPPER.readValue(HttpClientUtility.sendPost("api/users", jsonBody), new TypeReference<Post>() {});

                                                                /*POST dto*/
        System.out.println("*******************************");
        System.out.println("POST:");
        System.out.println("*******************************");
        System.out.println("\"name:\" " + posts.getName());
        System.out.println("\"job:\" " + posts.getJob());
        System.out.println("\"id:\" " + posts.getId());
        System.out.println("\"createdAt:\" " + posts.getCreatedAt());
        System.out.println("*******************************");
    }
}

