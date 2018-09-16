package com.yao.springbootweixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeixinApplication.class, args);
    }
}
