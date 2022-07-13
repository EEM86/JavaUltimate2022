package yym.svydovets.nasa.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

  private String firstName;
  private String lastName;
  private int trainingDaysPerWeek;
  private int minutesPerTrainingDay;

  public Person() {
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getTrainingDaysPerWeek() {
    return this.trainingDaysPerWeek;
  }

  public int getMinutesPerTrainingDay() {
    return this.minutesPerTrainingDay;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setTrainingDaysPerWeek(int trainingDaysPerWeek) {
    this.trainingDaysPerWeek = trainingDaysPerWeek;
  }

  public void setMinutesPerTrainingDay(int minutesPerTrainingDay) {
    this.minutesPerTrainingDay = minutesPerTrainingDay;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    final Person other = (Person) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$firstName = this.getFirstName();
    final Object other$firstName = other.getFirstName();
    if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) {
      return false;
    }
    final Object this$lastName = this.getLastName();
    final Object other$lastName = other.getLastName();
    if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) {
      return false;
    }
    if (this.getTrainingDaysPerWeek() != other.getTrainingDaysPerWeek()) {
      return false;
    }
    if (this.getMinutesPerTrainingDay() != other.getMinutesPerTrainingDay()) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Person;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $firstName = this.getFirstName();
    result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
    final Object $lastName = this.getLastName();
    result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
    result = result * PRIME + this.getTrainingDaysPerWeek();
    result = result * PRIME + this.getMinutesPerTrainingDay();
    return result;
  }

  public String toString() {
    return "Person(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", trainingDaysPerWeek="
        + this.getTrainingDaysPerWeek() + ", minutesPerTrainingDay=" + this.getMinutesPerTrainingDay() + ")";
  }
}
