package com.leepuvier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.leepuvier")
public class JavaLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLearnApplication.class, args);
    }

}
