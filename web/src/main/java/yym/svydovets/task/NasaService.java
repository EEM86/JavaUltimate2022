package yym.svydovets.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import yym.svydovets.nasa.data.Photo;
import yym.svydovets.nasa.data.Photos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

@Service
public class NasaService {

  private final static String URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";
  private final String API_KEY = "DEMO_KEY";

  @Cacheable("maxImage")
  public String findMaxImage(int sol) throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newBuilder().followRedirects(Redirect.ALWAYS).build();
    final URI uri = UriComponentsBuilder
        .fromHttpUrl(URL)
        .queryParam("sol", sol)
        .queryParam("API_KEY", API_KEY)
        .build()
        .toUri();
    final HttpResponse<String> response = httpClient.send(
        HttpRequest.newBuilder().GET().uri(uri).build(),
        BodyHandlers.ofString());
    final ObjectMapper objectMapper = new ObjectMapper();
    final Photos photos = objectMapper.readValue(response.body(), Photos.class);
    final SimpleImmutableEntry<String, Long> res = photos.getPhotos().parallelStream()
        .map(Photo::getImg_src)
        .map(img -> getContentLength(httpClient, img))
        .max(Entry.comparingByValue())
        .orElseThrow();
    return "Size to url:" + res.getValue() + ": " + res.getKey();
  }

  private AbstractMap.SimpleImmutableEntry<String, Long> getContentLength(HttpClient httpClient, String img) {
    try {
      final HttpResponse<String> headResponse = httpClient.send(
          HttpRequest.newBuilder().uri(URI.create(img)).method(HttpMethod.HEAD.name(), BodyPublishers.noBody()).build(),
          BodyHandlers.ofString());
      final long length = headResponse.headers().firstValueAsLong(HttpHeaders.CONTENT_LENGTH).orElse(0);
      return new AbstractMap.SimpleImmutableEntry<>(img, length);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new AbstractMap.SimpleImmutableEntry<>("noContent", 0L);
  }

}
