package com.bootdo.cust.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-25 20:01
 **/
public class CustConstant {
    public final static Map<String,String> BaiduResult = new HashMap<String, String>();
    static {
        BaiduResult.put("222209","face token不存在");
        BaiduResult.put("18","QPS超限额");
        BaiduResult.put("19","请求总量超限额");
        BaiduResult.put("110","Access Token失效");
        BaiduResult.put("111","Access token过期");
        BaiduResult.put("222202","图片中没有人脸");
        BaiduResult.put("222203","无法解析人脸");
        BaiduResult.put("222207","未找到匹配的用户");
        BaiduResult.put("222300","人脸图片添加失败");
        BaiduResult.put("222301","获取人脸图片失败");
        BaiduResult.put("223102","该用户已存在");
        BaiduResult.put("223104","group_list包含组\n" +
                "数量过多");
        BaiduResult.put("223105","该人脸已存在");
        BaiduResult.put("223114","人脸模糊");
        BaiduResult.put("223115","人脸光照不好");
    }
}
