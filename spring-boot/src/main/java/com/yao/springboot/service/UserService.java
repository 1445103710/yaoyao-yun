package com.yao.springboot.service;

import com.yao.springboot.dao.UserDao;
import com.yao.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-18 22:34
 **/
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findUserByName(String username){
        return userDao.findByUsername(username);
    }
}
