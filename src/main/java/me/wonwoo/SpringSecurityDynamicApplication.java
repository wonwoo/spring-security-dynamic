package me.wonwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SpringSecurityDynamicApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityDynamicApplication.class, args);
  }
}
