package yym.svydovets.web.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photos {

  private List<Photo> photos;

  public List<Photo> getPhotos() {
    return photos == null ? List.of() : photos;
  }
}
