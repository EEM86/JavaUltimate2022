package yym.svydovets.web.task;

import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQDemo {

  @SneakyThrows
  public static void main(String[] args) {
    var factory = new ConnectionFactory();
    factory.setHost("93.175.204.87");
    factory.setPort(5672);
    var connection = factory.newConnection();
    var chan = connection.createChannel();
//    writeToRabbit(chan);
    var queue = chan.queueDeclare("yermolenko-queue", true, false, false, null);
    chan.queueBind(queue.getQueue(), "announcements-topic", "breskul.*"); //*.*, *.warning

    DeliverCallback callBack = (o1, o2) -> {
      var s = new String(o2.getBody());
      System.out.println(s);
    };
    CancelCallback cancelCallback = tag -> {
    };
    chan.basicConsume("", callBack, cancelCallback);
  }

  private static void writeToRabbit(Channel chan) throws IOException, TimeoutException {
    chan.basicPublish("", "participants-queue", null,
        "[RabbitMQ error]: cannot parse message".getBytes(StandardCharsets.UTF_8));
  }

}
