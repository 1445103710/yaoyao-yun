package com.yao.service;

import com.yao.utils.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-25 21:44
 **/
public class CustMsg {
    public static String getMsg(String userId){
        String url = "http://120.77.254.63:8080/cust/fCust/get/"+userId;
        String info = new String(HttpUtil.doGet(url));
        return info;
    }

    public static void main(String[] args) {
        String s = getMsg("201808252054361");
        System.out.println(s);
    }
}
