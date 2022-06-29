package yym.svydovets.customSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/good_evening")
public class GoodEveningServlet extends HttpServlet {
  private static final String DEFAULT_NAME = "Buddy";
  private static final String NAME_PARAMETER = "name";
  private static final String CUSTOM_SESSION = "CUSTOM_SESSION";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    var writer = resp.getWriter();
    writer.printf("Good evening, %s", getName(req, resp));
  }

  private String getName(HttpServletRequest req, HttpServletResponse resp) {
    var parameterName = req.getParameter(NAME_PARAMETER);
    var customSessionCookie = getCustomSessionCookie(req);
    var optSessionId = customSessionCookie.map(Cookie::getValue);

    if (parameterName != null) {
      var sessionId = optSessionId.orElseGet(SessionStorage::generateSessionId);
      SessionStorage.putValue(sessionId, NAME_PARAMETER, parameterName);
      if (customSessionCookie.isEmpty()) {
        resp.addCookie(new Cookie(CUSTOM_SESSION, sessionId));
      }
      return parameterName;
    } else if (optSessionId.isPresent()) {
      var sessionName = SessionStorage.getValue(optSessionId.get(), NAME_PARAMETER);
      return sessionName.orElse(DEFAULT_NAME);
    }

    return DEFAULT_NAME;
  }

  private Optional<Cookie> getCustomSessionCookie(HttpServletRequest req) {
    var cookies = req.getCookies();
    if (cookies == null) {
      return Optional.empty();
    }

    return Arrays.stream(cookies)
        .filter(cookie -> CUSTOM_SESSION.equals(cookie.getName()))
        .findAny();
  }

  private static final class SessionStorage {

    private SessionStorage() {}

    private static final Map<String, Map<String, String>> STORAGE = new HashMap<>();

    public static String generateSessionId() {
      return UUID.randomUUID().toString();
    }

    public static void putValue(String sessionId, String parameter, String value) {
      if (sessionId == null) {
        sessionId = generateSessionId();
      }
      var session = STORAGE.computeIfAbsent(sessionId, k -> new HashMap<>());
      session.put(parameter, value);
    }

    public static Optional<String> getValue(String sessionId, String nameParameter) {
      var session = STORAGE.get(sessionId);
      if (session == null) {
        return Optional.empty();
      }
      return Optional.ofNullable(session.get(nameParameter));
    }

  }

}
