package com.yao.springboot.service;

import com.yao.springboot.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-19 10:56
 **/
@Service
public class RedisService {

    @Autowired
    private RedisDao redisDao;
    public void setKey(String key,String value){
        redisDao.setKey(key,value);
    }

    public String getKey(String key){
        return redisDao.getValue(key);
    }
}
