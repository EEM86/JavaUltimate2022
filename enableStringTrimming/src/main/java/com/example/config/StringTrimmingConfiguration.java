package com.example.config;

import com.example.enablestringtrimming.bpp.TrimmedAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringTrimmingConfiguration {

  @Bean
  public TrimmedAnnotationBeanPostProcessor getTrimmedBpp() {
    return new TrimmedAnnotationBeanPostProcessor();
  }

}
