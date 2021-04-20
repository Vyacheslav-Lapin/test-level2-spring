package ru.vlapin.experiments.testlevel2spring;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableFeignClients
@SpringBootApplication
@EnableHypermediaSupport(type = HAL)
public class TestLevel2SpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestLevel2SpringApplication.class, args);
  }
}
