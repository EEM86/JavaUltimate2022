package yym.svydovets.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import yym.svydovets.nasa.data.Person;
import yym.svydovets.nasa.data.Team;
import yym.svydovets.nasa.data.TeamWrapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService {

  public Person getGreatestTotalTrainingTime() throws IOException, InterruptedException {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpResponse<String> response = httpClient.send(
        HttpRequest.newBuilder().GET().uri(URI.create("http://93.175.204.87:8080/training/stats")).build(),
        BodyHandlers.ofString()
    );
    final ObjectMapper objectMapper = new ObjectMapper();
    final TeamWrapper teamWrapper = objectMapper.readValue(response.body(), TeamWrapper.class);
    final List<Team> teams = teamWrapper.getTeams();
    return teams.stream()
        .map(Team::getTeamMembers)
        .flatMap(List::stream)
        .max(Comparator.comparing(Person::getMinutesPerTrainingDay))
        .orElseThrow();
  }

}
