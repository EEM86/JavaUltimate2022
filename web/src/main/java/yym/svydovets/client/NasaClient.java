package yym.svydovets.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class NasaClient {

  private final String NASA_PICTURES = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15&api_key=DEMO_KEY";

  private RestTemplate restTemplate;

  @PostConstruct
  void action() {
    callNasa();
  }

  public void callNasa() {
    final ResponseEntity<Object[]> result = restTemplate.getForEntity(
        URI.create(NASA_PICTURES),
        Object[].class);
    final Object[] body = result.getBody();
    System.out.println(body);

  }

}
