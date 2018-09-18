//package com.yao.springbootweixin.itchat4j.weixin;
//
///**
// * @program: spring-cloud
// * @description:
// * @author: yaoyao_cmrpd
// * @create: 2018-09-16 23:04
// **/
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import com.yao.springbootweixin.itchat4j.api.WechatTools;
//import com.alibaba.fastjson.JSONObject;
//
//import com.yao.springbootweixin.itchat4j.Wechat;
//import com.yao.springbootweixin.itchat4j.face.IMsgHandlerFace;
//import com.yao.springbootweixin.itchat4j.utils.enums.MsgTypeEnum;
//import com.yao.springbootweixin.itchat4j.utils.tools.DownloadTools;
//
//public class WindowsSimpleDemo implements IMsgHandlerFace {
//
//    @Override
//    public String textMsgHandle(JSONObject msg) {
//        String text = msg.getString("Text");
//        String result = "收到文本信息： " + text;
//        return result;
//    }
//
//    @Override
//    public String picMsgHandle(JSONObject msg) {
//        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpg"; // 这里使用收到图片的时间作为文件名
//        String picPath = "D://data//itchat4j/pic" + File.separator + fileName; // 保存图片的路径
//        DownloadTools.getDownloadFn(msg, MsgTypeEnum.PIC.getType(), picPath); // 调用此方法来保存图片
//        return "图片保存成功";
//    }
//
//    @Override
//    public String voiceMsgHandle(JSONObject msg) {
//        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp3"; // 这里使用收到语音的时间作为文件名
//        String voicePath = "D://data//itchat4j/voice" + File.separator + fileName; // 保存语音的路径
//        DownloadTools.getDownloadFn(msg, MsgTypeEnum.VOICE.getType(), voicePath); // 调用此方法来保存语音
//        return "声音保存成功";
//    }
//
//    @Override
//    public String viedoMsgHandle(JSONObject msg) {
//        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp4"; // 这里使用收到小视频的时间作为文件名
//        String viedoPath = "D://data//itchat4j/viedo" + File.separator + fileName;// 保存小视频的路径
//        DownloadTools.getDownloadFn(msg, MsgTypeEnum.VIEDO.getType(), viedoPath);// 调用此方法来保存小视频
//        return "视频保存成功";
//    }
//
//    public static void main(String[] args) {
//        IMsgHandlerFace msgHandler = new WindowsSimpleDemo();
//        String qrPath = "D://data//itchat4j/login";
//        // Wechat wechat = new Wechat(msgHandler,
//        // "/home/itchat4j/demo/itchat4j/login");
//        Wechat wechat = new Wechat(msgHandler, qrPath);
//        wechat.start();
//        List<String> contactList = WechatTools.getContactList();
//        for (String name:contactList){
//            System.out.println("name-->"+name);
//        }
//
//    }
//
//    @Override
//    public String nameCardMsgHandle(JSONObject arg0) {
//        return "收到名片消息";
//    }
//}
