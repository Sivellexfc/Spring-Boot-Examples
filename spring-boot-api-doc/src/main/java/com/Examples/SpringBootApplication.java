package com.Examples;

import org.springframework.boot.SpringApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableSwagger2
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);

    }
}
