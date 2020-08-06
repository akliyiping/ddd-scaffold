package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class DddScaffoldApplication {

  public static void main(String[] args) {
	SpringApplication.run(DddScaffoldApplication.class, args);
  }

}
