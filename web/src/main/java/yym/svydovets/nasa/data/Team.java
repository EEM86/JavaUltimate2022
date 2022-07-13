package yym.svydovets.nasa.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

  private String team;
  private List<Person> teamMembers;
  private int teamMembersCount;
  private BigDecimal teamAverageDaysPerWeek;
  private BigDecimal teamAverageMinutesPerTrainingDay;

  public Team() {
  }

  public String getTeam() {
    return this.team;
  }

  public List<Person> getTeamMembers() {
    return this.teamMembers;
  }

  public int getTeamMembersCount() {
    return this.teamMembersCount;
  }

  public BigDecimal getTeamAverageDaysPerWeek() {
    return this.teamAverageDaysPerWeek;
  }

  public BigDecimal getTeamAverageMinutesPerTrainingDay() {
    return this.teamAverageMinutesPerTrainingDay;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public void setTeamMembers(List<Person> teamMembers) {
    this.teamMembers = teamMembers;
  }

  public void setTeamMembersCount(int teamMembersCount) {
    this.teamMembersCount = teamMembersCount;
  }

  public void setTeamAverageDaysPerWeek(BigDecimal teamAverageDaysPerWeek) {
    this.teamAverageDaysPerWeek = teamAverageDaysPerWeek;
  }

  public void setTeamAverageMinutesPerTrainingDay(BigDecimal teamAverageMinutesPerTrainingDay) {
    this.teamAverageMinutesPerTrainingDay = teamAverageMinutesPerTrainingDay;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Team)) {
      return false;
    }
    final Team other = (Team) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$team = this.getTeam();
    final Object other$team = other.getTeam();
    if (this$team == null ? other$team != null : !this$team.equals(other$team)) {
      return false;
    }
    final Object this$teamMembers = this.getTeamMembers();
    final Object other$teamMembers = other.getTeamMembers();
    if (this$teamMembers == null ? other$teamMembers != null : !this$teamMembers.equals(other$teamMembers)) {
      return false;
    }
    if (this.getTeamMembersCount() != other.getTeamMembersCount()) {
      return false;
    }
    final Object this$teamAverageDaysPerWeek = this.getTeamAverageDaysPerWeek();
    final Object other$teamAverageDaysPerWeek = other.getTeamAverageDaysPerWeek();
    if (this$teamAverageDaysPerWeek == null ? other$teamAverageDaysPerWeek != null
        : !this$teamAverageDaysPerWeek.equals(other$teamAverageDaysPerWeek)) {
      return false;
    }
    final Object this$teamAverageMinutesPerTrainingDay = this.getTeamAverageMinutesPerTrainingDay();
    final Object other$teamAverageMinutesPerTrainingDay = other.getTeamAverageMinutesPerTrainingDay();
    if (this$teamAverageMinutesPerTrainingDay == null ? other$teamAverageMinutesPerTrainingDay != null
        : !this$teamAverageMinutesPerTrainingDay.equals(other$teamAverageMinutesPerTrainingDay)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Team;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $team = this.getTeam();
    result = result * PRIME + ($team == null ? 43 : $team.hashCode());
    final Object $teamMembers = this.getTeamMembers();
    result = result * PRIME + ($teamMembers == null ? 43 : $teamMembers.hashCode());
    result = result * PRIME + this.getTeamMembersCount();
    final Object $teamAverageDaysPerWeek = this.getTeamAverageDaysPerWeek();
    result = result * PRIME + ($teamAverageDaysPerWeek == null ? 43 : $teamAverageDaysPerWeek.hashCode());
    final Object $teamAverageMinutesPerTrainingDay = this.getTeamAverageMinutesPerTrainingDay();
    result = result * PRIME + ($teamAverageMinutesPerTrainingDay == null ? 43
        : $teamAverageMinutesPerTrainingDay.hashCode());
    return result;
  }

  public String toString() {
    return "Team(team=" + this.getTeam() + ", teamMembers=" + this.getTeamMembers() + ", teamMembersCount="
        + this.getTeamMembersCount() + ", teamAverageDaysPerWeek=" + this.getTeamAverageDaysPerWeek()
        + ", teamAverageMinutesPerTrainingDay=" + this.getTeamAverageMinutesPerTrainingDay() + ")";
  }
}
