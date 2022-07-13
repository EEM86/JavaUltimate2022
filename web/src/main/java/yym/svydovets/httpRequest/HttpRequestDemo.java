package yym.svydovets.httpRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.stream.StreamSupport;

public class HttpRequestDemo {

  private final static String NASA_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15&api_key=DEMO_KEY";

  public static void main(String[] args) throws IOException, InterruptedException {
//    viaRestTemplate();
//    viaHttpClient();
      sendPost();
  }

  private static void sendPost() throws IOException, InterruptedException {
    String body = "{\n"
        + "  \"firstName\": \"Yevhen\",\n"
        + "  \"lastName\": \"Yermolenko\",\n"
        + "  \"team\": \"Svydovets\",\n"
        + "  \"trainingDaysPerWeek\": 4,\n"
        + "  \"minutesPerTrainingDay\": 60\n"
        + "}";

    final HttpClient httpClient = HttpClient.newHttpClient();
    final BodyPublisher bodyPub = BodyPublishers.ofString(body);
    final HttpResponse<String> response = httpClient.send(
        HttpRequest.newBuilder()
            .POST(bodyPub)
            .uri(URI.create("http://93.175.204.87:8080/training/stats"))
            .header(HttpHeaders.CONTENT_TYPE, "application/json").build(),
        BodyHandlers.ofString()
    );
    System.out.println("Resp status: " + response.statusCode());
  }

  private static void viaHttpClient() throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpResponse<String> response = httpClient.send(
        HttpRequest.newBuilder().GET().uri(URI.create(NASA_URL)).build(),
        BodyHandlers.ofString()
    );
    final ObjectMapper objectMapper = new ObjectMapper();
    final JsonNode jsonNodeResponse = objectMapper.readTree(response.body());
    System.out.println("Via HttpClient:");
    StreamSupport.stream(jsonNodeResponse.get("photos").spliterator(), false)
        .map(p -> p.get("img_src"))
        .map(JsonNode::asText)
        .limit(5)
        .forEach(System.out::println);
  }

  private static void viaRestTemplate() {
    final RestTemplate restTemplate = new RestTemplate();

//    final Photos photos = restTemplate.getForObject(NASA_URL, Photos.class);
//    photos.getPhotos().stream()
//        .map(Photo::getImg_src)
//        .forEach(System.out::println);

    System.out.println("From JsonNode standard:");
    final JsonNode jsonNodeResponse = restTemplate.getForObject(NASA_URL, JsonNode.class);
//    final JsonNode jsonPhotos = jsonNodeResponse.get("photos");
//    jsonPhotos.forEach(photo -> System.out.println(photo.get("img_src").asText()));

    System.out.println("From JsonNode using streamSupport:");
    StreamSupport.stream(jsonNodeResponse.get("photos").spliterator(), false)
        .map(p -> p.get("img_src"))
        .map(JsonNode::asText)
        .forEach(System.out::println);
  }

}
