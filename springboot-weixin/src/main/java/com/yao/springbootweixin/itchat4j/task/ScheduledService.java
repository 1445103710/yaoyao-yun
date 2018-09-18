package com.yao.springbootweixin.itchat4j.task;

import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.DateUtil;
import com.yao.springbootweixin.itchat4j.api.MessageTools;
import com.yao.springbootweixin.itchat4j.task.jobhandler.WeatherHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-17 00:03
 **/
@Slf4j
//@Component
public class ScheduledService {
//    @Scheduled(cron = "0/30 * * * * *")
//    public void scheduled() throws Exception {
//        String dateStart = DateUtil.format(new Date());
//        XxlJobLogger.log("---------------开始执行天气预报程序["+dateStart+"]------------------");
//        log.info("开始执行天气预报程序["+dateStart+"]");
//        String info = WeatherHandle.getWeatherString("合肥");
//        XxlJobLogger.log("获取结果-->"+info);
//        //核心业务模块
//        boolean b = MessageTools.sendMsgByNickName("每句话，好好说", info);
//        if (b){
//            XxlJobLogger.log("执行发送微信成功！");
//        }else {
//            XxlJobLogger.log("执行发送微信失败！");
//        }
//
//        String dateEnd = DateUtil.format(new Date());
//        log.info("结束执行天气预报程序["+dateEnd+"]");
//        XxlJobLogger.log("---------------结束执行天气预报程序["+dateEnd+"]------------------");
//    }
//    @Scheduled(cron = "0 50 0 * * *")
//    public void scheduled2(){
//        log.info("测试定时任务");
//        MessageTools.sendMsgByNickName(System.currentTimeMillis()+"：测试","친 구");
//        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
//    }
//    @Scheduled(cron = "0 10 3 * * *")
//    public void scheduled3(){
//        log.info("测试定时任务");
//        MessageTools.sendMsgByNickName("宝，老公知道错了。。。不生气了","娜");
//        MessageTools.sendMsgByNickName("宝宝，老公真的知道错了。。。不生气了","娜");
//        log.info("=====>>>>>使用cron发送给老婆  {}",System.currentTimeMillis());
//    }
//    @Scheduled(cron = "0 30 5 * * *")
//    public void scheduled5(){
//        log.info("测试定时任务");
//        MessageTools.sendMsgByNickName("宝晚安晚安，老公错了。。。","娜");
//        log.info("=====>>>>>使用cron发送给老婆  {}",System.currentTimeMillis());
//    }
//    @Scheduled(cron = "0 20 6 * * *")
//    public void scheduled6(){
//        log.info("测试定时任务");
//        MessageTools.sendMsgByNickName("老公错了老婆。。。","娜");
//        MessageTools.sendMsgByNickName("猪。。。","娜");
//        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
//    }
}
