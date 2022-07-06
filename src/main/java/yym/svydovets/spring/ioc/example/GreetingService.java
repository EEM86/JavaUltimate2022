package yym.svydovets.spring.ioc.example;

import yym.svydovets.spring.ioc.annotation.Bean;

@Bean
public class GreetingService implements TalkingService {

  @Override
  public void talk() {
    System.out.println("Hello");
  }
}
