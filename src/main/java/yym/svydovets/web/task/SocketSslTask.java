package yym.svydovets.web.task;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SocketSslTask {

  private static final String PHOTOS_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=300&api_key=qWws2hdBXWMLsXsQpOhD05WhqLl9wjr3ns0grRHL";
  private static final int HTTPS_PORT = 443;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public Picture findTheLargestNasaPicture() {
    return getImgUrls().stream()
        .parallel()
        .map(this::getLocation)
        .map(location -> new Picture(location, getSize(location)))
        .max(Comparator.comparing(Picture::size))
        .orElseThrow();
  }

  private Socket openSSLConnection(String host) {
    try {
      SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
      SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket(host, HTTPS_PORT);
      sslSocket.startHandshake();
      SSLSession session = sslSocket.getSession();
      if (!session.isValid()) {
        throw new RuntimeException("SSL Session is not valid");
      }
      return sslSocket;
    } catch (IOException e) {
      throw new RuntimeException("Unable to obtain SSL Socket connection", e);
    }
  }

  @SneakyThrows
  private List<String> getImgUrls() {
    HttpRequest request = HttpRequest.of(
        Http.Method.GET, PHOTOS_URL, Map.of(Http.Header.ACCEPT, "application/json")
    );
    HttpResponse response = execute(request);
    if (response.statusCode != 200) {
      throw new RuntimeException("Request is not ok. Status code: " + response.statusCode);
    }
    String responseJson = response.body.stream()
        .filter(ln -> ln.contains("{"))
        .collect(Collectors.joining());
    JsonNode photos = objectMapper.readTree(responseJson).get("photos");
    return StreamSupport.stream(photos.spliterator(), false)
        .map(node -> node.get("img_src"))
        .map(JsonNode::asText)
        .toList();
  }

  @SneakyThrows
  private String getLocation(String imgUrl) {
    HttpRequest httpRequest = HttpRequest.of(Http.Method.HEAD, imgUrl);
    HttpResponse response = execute(httpRequest);
    return response.headers.get(Http.Header.LOCATION);
  }

  @SneakyThrows
  private long getSize(String location) {
    HttpRequest httpRequest = HttpRequest.of(Http.Method.HEAD, location);
    HttpResponse response = execute(httpRequest);
    String contentLength = response.headers.get(Http.Header.CONTENT_LENGTH);
    return Long.parseLong(contentLength);
  }

  private HttpResponse execute(HttpRequest request) {
    try (Socket socket = openSSLConnection(request.url.getHost())) {
      PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
      printWriter.println(Http.http(request.method, request.url.getFile()));
      request.headers.forEach((key, value) -> printWriter.println(Http.header(key, value)));
      printWriter.println();
      printWriter.flush();

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      List<String> lines = new ArrayList<>();
      String line = reader.readLine();
      int emptyLinesCount = 0;
      while (line != null) {
        if (line.isEmpty()) {
          emptyLinesCount++;
        }
        if (emptyLinesCount >= request.method.emptyLinesCount) {
          break;
        }
        lines.add(line);
        line = reader.readLine();
      }
      return HttpResponse.of(
          parseStatusCode(lines),
          parseHeaders(lines),
          parseBody(lines)
      );
    } catch (IOException ioException) {
      throw new RuntimeException(ioException);
    }
  }

  private int parseStatusCode(List<String> lines) {
    return Integer.parseInt(lines.get(0).split(" ")[1]);
  }

  private List<String> parseBody(List<String> lines) {
    return lines.stream().dropWhile(ln -> !ln.isEmpty())
        .skip(1)
        .collect(Collectors.toList());
  }

  private Map<String, String> parseHeaders(List<String> lines) {
    return lines.stream().takeWhile(ln -> !ln.isEmpty())
        .skip(1)
        .collect(Collectors.toMap(
            ln -> ln.split(Http.Header.HEADER_COLON)[0],
            ln -> ln.split(Http.Header.HEADER_COLON)[1],
            (a, b) -> a)
        );
  }

  public static void main(String[] args) {
    SocketSslTask socketSslTask = new SocketSslTask();
    long start = System.currentTimeMillis();
    System.out.println("The largest picture is: " + socketSslTask.findTheLargestNasaPicture());
    System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) + "ms");
  }

  record Picture(
      String url,
      long size
  ) {
  }

  static class Http {

    static String HTTP_FORMAT = "%s %s HTTP/1.1";
    static String HEADER_FORMAT = "%s: %s";

    static String http(Http.Method method, String path) {
      return String.format(HTTP_FORMAT, method, path);
    }

    static String header(String key, String value) {
      return String.format(HEADER_FORMAT, key, value);
    }

    enum Method {
      GET("GET", 2), HEAD("HEAD", 1);

      final String name;
      final int emptyLinesCount;

      Method(String name, int emptyLinesCount) {
        this.name = name;
        this.emptyLinesCount = emptyLinesCount;
      }

      @Override
      public String toString() {
        return name;
      }
    }

    class Header {
      static final String HEADER_COLON = ": ";
      static final String ACCEPT = "Accept";
      static final String HOST = "Host";
      static final String CONTENT_LENGTH = "Content-Length";
      static final String LOCATION = "Location";
    }
  }

  record HttpRequest(
      Http.Method method,
      Map<String, String> headers,
      URL url
  ) {
    static HttpRequest of(Http.Method method, String url, Map<String, String> headers) {
      try {
        URL requestUrl = new URL(url);
        return new HttpRequest(method, addDefaultHeaders(headers, requestUrl), requestUrl);
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }

    static HttpRequest of(Http.Method method, String url) {
      return of(method, url, Map.of(Http.Header.ACCEPT, "*/*"));
    }

    static Map<String, String> addDefaultHeaders(Map<String, String> headers, URL url) {
      Map<String, String> completeHeaders = new HashMap<>(headers);
      completeHeaders.put(Http.Header.HOST, url.getHost());
      return completeHeaders;
    }
  }

  static class HttpResponse {
    int statusCode;
    Map<String, String> headers;
    List<String> body;

    private HttpResponse(int statusCode, Map<String, String> headers, List<String> body) {
      this.statusCode = statusCode;
      this.headers = headers;
      this.body = body;
    }

    static HttpResponse of(int statusCode, Map<String, String> headers, List<String> body) {
      return new HttpResponse(statusCode, headers, body);
    }
  }

}
