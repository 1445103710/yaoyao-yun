package com.yao.springboot.controller;

import com.yao.springboot.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-19 10:59
 **/
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/{key}/{value}")
    public String setRedisService(@PathVariable("key")String key,@PathVariable("value")String value){
        log.debug("获取缓存参数key["+key+"],value["+value+"]");
        redisService.setKey(key,value);
        return "缓存加入成功";
    }
    @RequestMapping("/key/{key}")
    public String getRedisService(@PathVariable("key")String key){
        log.debug("获取缓存key："+key);
        return redisService.getKey(key);
    }
}
