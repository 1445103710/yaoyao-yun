package com.yao.job;

import com.yao.server.MyWebSocket;
import com.yao.server.WebSocketTaskHanlder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-11 23:21
 **/
@Component
@Slf4j
public class WebSocketTask {
    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        String message = "您好"+"[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++);
        List<Session> sessionList = MyWebSocket.getSessionList();
        for(Session session:sessionList){
            if(session != null){
                try {
                    session.getBasicRemote().sendText(message);
                }catch (Exception e){
                    log.error("定时任务异常:{}",e);
                }
            }
           }
//        WebSocketSession session = map.get("xuelongjiang");//这里用户ID的获取可以根据具体业务，这里为了更简单的演示。
//        if(session != null){
//            try {
//                session.sendMessage(new TextMessage(message));
//            }catch (Exception e){
//                log.error("定时任务异常:{}",e);
//            }
//        }
//        try {
//            MyWebSocket myWebSocket = new MyWebSocket();
//            myWebSocket.sendMessage("您好"+"[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++));
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        System.out.println("[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++));
    }
}
