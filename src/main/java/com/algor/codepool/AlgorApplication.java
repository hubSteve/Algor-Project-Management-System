package com.algor.codepool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AlgorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorApplication.class, args);
    }

}
