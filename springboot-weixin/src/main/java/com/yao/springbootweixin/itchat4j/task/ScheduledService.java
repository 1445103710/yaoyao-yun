package com.yao.springbootweixin.itchat4j.task;

import com.yao.springbootweixin.itchat4j.api.MessageTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-17 00:03
 **/
@Slf4j
@Component
public class ScheduledService {
//    @Scheduled(cron = "0/5 * * * * *")
//    public void scheduled(){
//        log.info("测试定时任务");
//        MessageTools.sendMsgByNickName(System.currentTimeMillis()+"：测试","친 구");
//        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
//    }
    @Scheduled(cron = "0 50 0 * * *")
    public void scheduled2(){
        log.info("测试定时任务");
        MessageTools.sendMsgByNickName(System.currentTimeMillis()+"：测试","친 구");
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
    @Scheduled(cron = "0 10 3 * * *")
    public void scheduled3(){
        log.info("测试定时任务");
        MessageTools.sendMsgByNickName("宝，老公知道错了。。。不生气了","娜");
        MessageTools.sendMsgByNickName("宝宝，老公真的知道错了。。。不生气了","娜");
        log.info("=====>>>>>使用cron发送给老婆  {}",System.currentTimeMillis());
    }
    @Scheduled(cron = "0 30 5 * * *")
    public void scheduled5(){
        log.info("测试定时任务");
        MessageTools.sendMsgByNickName("宝晚安晚安，老公错了。。。","娜");
        log.info("=====>>>>>使用cron发送给老婆  {}",System.currentTimeMillis());
    }
    @Scheduled(cron = "0 20 6 * * *")
    public void scheduled6(){
        log.info("测试定时任务");
        MessageTools.sendMsgByNickName("老公错了老婆。。。","娜");
        MessageTools.sendMsgByNickName("猪。。。","娜");
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
}
