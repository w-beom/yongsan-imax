package com.youngsanimax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YoungsanImaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoungsanImaxApplication.class, args);
    }

}
