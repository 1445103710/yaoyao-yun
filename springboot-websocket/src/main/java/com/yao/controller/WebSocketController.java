package com.yao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-11 23:09
 **/
@Controller
public class WebSocketController {
    @RequestMapping(value="/pushVideoListToWeb",method=RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<String,Object>();

        try {
            //WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+CommonUtils.getValue(param, "sltAccountId"));
            result.put("operationResult", true);
        }catch (Exception e) {
            result.put("operationResult", true);
        }
        return result;
    }
    @RequestMapping("/webSocket")
    public String getWebSocket(){
        return "WebSocket";
    }
}
