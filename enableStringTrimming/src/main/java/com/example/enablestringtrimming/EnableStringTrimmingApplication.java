package com.example.enablestringtrimming;

import com.example.enablestringtrimming.annotation.EnableStringTrimming;
import com.example.enablestringtrimming.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableStringTrimming
public class EnableStringTrimmingApplication {

  public static void main(String[] args) {
    var ctx = SpringApplication.run(EnableStringTrimmingApplication.class, args);
    var bean = ctx.getBean(DemoService.class);
    bean.printTrimmedWord("    example     ");
  }

}
