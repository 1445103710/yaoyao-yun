package com.yao.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-19 22:31
 **/
@RestController
@RequestMapping(value = "/rest")
public class RestTestController {
    @GetMapping("/testRest")
    public String testRest(){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject("https://www.baidu.com",String.class);
    }
}
