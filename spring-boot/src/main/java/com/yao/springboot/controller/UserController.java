package com.yao.springboot.controller;

import com.yao.springboot.entity.User;
import com.yao.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-18 22:36
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
        System.out.println("aaaa");
        log.debug("username:"+username);
        return userService.findUserByName(username);
    }
}
