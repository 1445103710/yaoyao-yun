package com.yao.springboot.controller;

import com.yao.springboot.config.ConfigBean;
import com.yao.springboot.entity.Users;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-18 21:16
 **/
@RestController
@EnableConfigurationProperties({ConfigBean.class,Users.class})
public class YaoyaoController {
    @Autowired
    ConfigBean configBean;
    @Autowired
    Users users;
    @ApiOperation(value = "获取配置数据")
    @RequestMapping("/yaoyao")
    public String miya(){
        return configBean.toString();
    }

    @ApiOperation(value = "获取user数据")
    @RequestMapping("/users")
    public String getUser(){
        return users.toString();
    }

}
