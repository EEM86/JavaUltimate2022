package yym.svydovets.web.task;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Demo {

  public static void main(String[] args) {
    var host = "93.175.204.87";
    var port = 8888;
    var json = "username: ju22user\npassword: ju22pass\n";
//    var json = "{\"username\": \"ju22user\", \"password\": \"ju22pass\"}";
    try (var socket = new Socket(host, port);
         var out = socket.getOutputStream();
         var in = socket.getInputStream();
        var is = new InputStreamReader(in);
        var br = new BufferedReader(is);) {

      final PrintWriter writer = new PrintWriter(out);
      writer.println("POST /login HTTP/1.1");
      writer.println("HOST: 93.175.204.87");
      writer.println("Content-Type: application/x-www-form-urlencoded");
      writer.println("Content-Length: " + json.length());
      writer.println();
      writer.println(json);
      writer.println();
      writer.flush();

      while (br.ready()) {
        System.out.println(br.readLine());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

    }

  }

}
