package com.ezliv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SectionManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SectionManagerApplication.class, args);
    }
}
