package com.toy.aeky.natmal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class NatmalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NatmalApplication.class, args);
    }

}
