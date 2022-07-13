package yym.svydovets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yym.svydovets.nasa.data.Person;
import yym.svydovets.task.TeamService;

import java.io.IOException;

@RestController
public class TeamController {

  private TeamService service;

  @Autowired
  public TeamController(TeamService service) {
    this.service = service;
  }

  @GetMapping("/people/max")
  public Person printLargestImage() throws IOException, InterruptedException {
    final Person result = service.getGreatestTotalTrainingTime();
    System.out.println("Person with the greatestTrainingTime: " + result.getFirstName() + " " + result.getLastName());
    return result;
  }
}
