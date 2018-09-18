//package com.yao.springbootweixin.itchat4j.weixin;
//
//import com.yao.springbootweixin.itchat4j.face.IMsgHandlerFace;
//import com.yao.springbootweixin.itchat4j.utils.enums.MsgTypeEnum;
//import com.yao.springbootweixin.itchat4j.utils.tools.DownloadTools;
//import com.alibaba.fastjson.JSONObject;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @program: spring-cloud
// * @description:
// * @author: yaoyao_cmrpd
// * @create: 2018-09-16 22:51
// **/
//public class Demo implements IMsgHandlerFace {
//    @Override
//    public String textMsgHandle(JSONObject msg) {
//        String text = msg.getString("Text");
//        return text;
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
//    @Override
//    public String nameCardMsgHandle(JSONObject arg0) {
//        return "收到名片消息";
//    }
//}
