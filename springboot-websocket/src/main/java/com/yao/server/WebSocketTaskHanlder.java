package com.yao.server;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-12 13:46
 **/
@Slf4j
public class WebSocketTaskHanlder extends TextWebSocketHandler {
    private static Map<String,WebSocketSession> userIdSessionMap = new ConcurrentHashMap();
    private static Map<WebSocketSession,String> sessionUserIdMap = new ConcurrentHashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String  payload = message.getPayload();
        log.info("websocket请求参数payload:{}",payload);
        JSONObject jsonObject = JSONObject.parseObject(payload);
        String action = jsonObject.getString("action");

        if("register".equals(action)){
            log.info("注册websocket连接");
            String userId = jsonObject.getString("userId");
            log.info("userId:{}注册session:{}",userId,session.getId());
            userIdSessionMap.put(userId,session);
            sessionUserIdMap.put(session,userId);
        }
    }

    //定时任务获取session
    public  static Map<String,WebSocketSession> getUserIdSessionMap(){
        return userIdSessionMap;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        //连接关闭后移除
        String userId = sessionUserIdMap.get(session);
        userIdSessionMap.remove(userId);
        log.info("websocket session:{}关闭原因:{}",session,status);
    }
}