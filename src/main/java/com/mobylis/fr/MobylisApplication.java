package com.mobylis.fr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class MobylisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobylisApplication.class, args);
    }

}
