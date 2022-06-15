package yym.svydovets.web.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Get the largest image from NASA photos link
 */
public class PrintNasaImagesUrl {

  public static void main(String[] args) {
    final String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15&api_key=DEMO_KEY";
    final RestTemplate restTemplate = new RestTemplate();

    final ResponseEntity<Photos> response = restTemplate.getForEntity(url, Photos.class);
    final Photos photos = Optional.ofNullable(response.getBody()).orElseThrow();

    final TreeMap<Long, List<String>> collection = photos.getPhotos()
        .stream()
        .collect(Collectors.groupingBy(
            photo -> getContentLength(restTemplate, photo),
            TreeMap::new,
            Collectors.mapping(Photo::getImg_src, Collectors.toList())));

    System.out.println(collection.lastEntry());

  }

  private static long getContentLength(RestTemplate restTemplate, Photo photo) {
    final URI location = restTemplate.headForHeaders(URI.create(photo.getImg_src())).getLocation();
    return location == null ? 0 : restTemplate.headForHeaders(location).getContentLength();
  }

}
