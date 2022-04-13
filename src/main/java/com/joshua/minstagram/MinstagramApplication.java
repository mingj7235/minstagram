package com.joshua.minstagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinstagramApplication.class, args);
    }

}
