package yym.svydovets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class NasaApp {

  public static void main(String[] args) {
    SpringApplication.run(NasaApp.class, args);
  }

  @CacheEvict("maxImage")
  @Scheduled(cron = "0 0 * * * *")
  public void cleanCache() {
    log.info("Cache was evicted");
  }

}
