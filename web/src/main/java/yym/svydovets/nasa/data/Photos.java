package yym.svydovets.nasa.data;

import java.util.List;

public class Photos {
  private List<Photo> photos;

  public Photos() {
  }

  public List<Photo> getPhotos() {
    return this.photos;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Photos)) {
      return false;
    }
    final Photos other = (Photos) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$photos = this.getPhotos();
    final Object other$photos = other.getPhotos();
    if (this$photos == null ? other$photos != null : !this$photos.equals(other$photos)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Photos;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $photos = this.getPhotos();
    result = result * PRIME + ($photos == null ? 43 : $photos.hashCode());
    return result;
  }

  public String toString() {
    return "Photos(photos=" + this.getPhotos() + ")";
  }
}
