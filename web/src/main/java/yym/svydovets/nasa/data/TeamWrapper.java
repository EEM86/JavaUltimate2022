package yym.svydovets.nasa.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamWrapper {

  private List<Team> teams;

  public TeamWrapper() {
  }

  public List<Team> getTeams() {
    return this.teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof TeamWrapper)) {
      return false;
    }
    final TeamWrapper other = (TeamWrapper) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$teams = this.getTeams();
    final Object other$teams = other.getTeams();
    if (this$teams == null ? other$teams != null : !this$teams.equals(other$teams)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof TeamWrapper;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $teams = this.getTeams();
    result = result * PRIME + ($teams == null ? 43 : $teams.hashCode());
    return result;
  }

  public String toString() {
    return "TeamWrapper(teams=" + this.getTeams() + ")";
  }
}
