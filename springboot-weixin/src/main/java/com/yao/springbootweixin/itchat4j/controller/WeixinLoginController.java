package com.yao.springbootweixin.itchat4j.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.springbootweixin.itchat4j.api.MessageTools;
import com.yao.springbootweixin.itchat4j.api.WechatTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-16 23:45
 **/
@Controller
@RequestMapping("/login")
@Slf4j
public class WeixinLoginController {
    @Value("${qrPath}")
    private String qrPath;
    @RequestMapping("weixin")
    public String loginWeixin(){
        LoginController login = new LoginController();
        log.warn("----->登录开始");
        login.login(qrPath);
        List<String> contactNickNameList = WechatTools.getContactNickNameList();
        StringBuffer stringBuffer = new StringBuffer();
        for (String name:contactNickNameList){
            log.warn("----->获取好友名称");
            log.warn("name---->"+name);
            stringBuffer.append("好友姓名："+name);
        }
        List<JSONObject> contactList = WechatTools.getContactList();
        for (JSONObject nameInfo:contactList){
            log.warn("----->获取好友信息");
            log.warn("nameInfo---->"+nameInfo.toJSONString());
        }
        //MessageTools.sendMsgByNickName("测试","恰年少");
        return stringBuffer.toString();
    }
}
