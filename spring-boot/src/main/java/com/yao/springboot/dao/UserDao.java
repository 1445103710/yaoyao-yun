package com.yao.springboot.dao;

import com.yao.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-07-18 22:32
 **/

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
