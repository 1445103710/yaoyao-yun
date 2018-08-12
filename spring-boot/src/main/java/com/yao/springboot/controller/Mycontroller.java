package com.yao.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-17 23:27
 **/
@RestController
public class Mycontroller {
    @Value("${my.name}")
    String name;
    @Value("${my.age}")
    String age;

    @RequestMapping("/ha")
    String getSome(){
        return name+":"+age;
    }
}
