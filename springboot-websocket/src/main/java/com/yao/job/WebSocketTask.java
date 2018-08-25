package com.yao.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.yao.server.MyWebSocket;
import com.yao.server.WebSocketTaskHanlder;
import com.yao.service.CustMsg;
import com.yao.utils.File.BaiduFile;
import com.yao.utils.baidu.Base64Util;
import com.yao.utils.baidu.face.FaceSearch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Scheduled(cron="*/15 * * * * ?")
    private void process(){
        //String message = "您好"+"[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++);
        String text = null;
        List<Session> sessionList = MyWebSocket.getSessionList();
        List<String> fileNames = BaiduFile.getFileNames(BaiduFile.getFiles());
        for (String fileName:fileNames){
            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            }catch (Exception e){
                e.printStackTrace();
            }
            String base64File = BaiduFile.getImageStr(fileName);
            String message = getUserInfo(base64File);
            if (StringUtils.isEmpty(message)){
                JSONObject custNew = new JSONObject();
                custNew.put("code","500");
                custNew.put("msg","未知错误");
                text = custNew.toJSONString();
            }else {
                JSONObject msg = JSON.parseObject(message);
                if (!("0".equals(msg.getString("error_code")))){
                    System.out.println("xxxxq"+msg.get("error_code"));
                    JSONObject custNew = new JSONObject();
                    custNew.put("code","1");
                    custNew.put("msg","新用户");
                    String[] names = fileName.split("\\\\");
                    custNew.put("pic",names[names.length-1]);
                    text = custNew.toJSONString();
                }else if("0".equals(msg.getString("error_code"))){
                    System.out.println("xxxxw"+msg.get("error_code"));
                    JSONObject oldtNew = new JSONObject();
                    oldtNew.put("code","0");
                    oldtNew.put("msg","老客户驾到！！！");
                    String[] names = fileName.split("\\\\");
                    oldtNew.put("pic",names[names.length-1]);
                    JSONObject resultJson = msg.getJSONObject("result");
                    System.out.println("xxxx"+resultJson.toJSONString());
                    JSONArray user_list = resultJson.getJSONArray("user_list");
                    JSONObject user = user_list.getJSONObject(0);
                    String userId = user.getString("user_id");
                    String custMsg = CustMsg.getMsg(userId);
                    if(custMsg==null){
                        oldtNew.put("userName","客户信息被删除，请核查人脸库！");
                        oldtNew.put("phonenumber","-");
                        oldtNew.put("sex","-");
                        text = oldtNew.toJSONString();
                    }else {
                        JSONObject custMsgJson = JSON.parseObject(custMsg);
                        System.out.println("##########"+custMsgJson.toJSONString());
                        oldtNew.put("userName",custMsgJson.getString("userName"));
                        oldtNew.put("phonenumber",custMsgJson.getString("phonenumber"));
                        oldtNew.put("sex",custMsgJson.getString("sex"));
                        text = oldtNew.toJSONString();
                    }
                }else {
                    System.out.println("xxxxe"+msg.get("error_code"));
                    JSONObject custNew = new JSONObject();
                    custNew.put("code","1");
                    custNew.put("msg","新用户");
                    custNew.put("pic","fileName");
                    text = custNew.toJSONString();
                }
            }


            for(Session session:sessionList){
                if(session != null){
                    try {
                        //session.getBasicRemote().sendText("欢迎光临第"+count+"用户"+message);
                        System.out.println(text);
                        session.getBasicRemote().sendText(text);
                    }catch (Exception e){
                        log.error("定时任务异常:{}",e);
                    }
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

    public String getUserInfo(String file){

        JSONObject faceJson = JSONObject.parseObject(FaceSearch.GetFilePathSearch(file));

        return faceJson.toJSONString();

    }



}
