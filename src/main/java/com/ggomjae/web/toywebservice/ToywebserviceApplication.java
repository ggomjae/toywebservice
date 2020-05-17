package com.ggomjae.web.toywebservice;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToywebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToywebserviceApplication.class, args);
    }
}
