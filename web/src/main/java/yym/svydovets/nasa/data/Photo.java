package yym.svydovets.nasa.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
  private String img_src;

  public Photo() {
  }

  public String getImg_src() {
    return this.img_src;
  }

  public void setImg_src(String img_src) {
    this.img_src = img_src;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Photo)) {
      return false;
    }
    final Photo other = (Photo) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$img_src = this.getImg_src();
    final Object other$img_src = other.getImg_src();
    if (this$img_src == null ? other$img_src != null : !this$img_src.equals(other$img_src)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Photo;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $img_src = this.getImg_src();
    result = result * PRIME + ($img_src == null ? 43 : $img_src.hashCode());
    return result;
  }

  public String toString() {
    return "Photo(img_src=" + this.getImg_src() + ")";
  }
}
