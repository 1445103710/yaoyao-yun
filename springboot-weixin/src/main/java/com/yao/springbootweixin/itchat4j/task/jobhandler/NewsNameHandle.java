package com.yao.springbootweixin.itchat4j.task.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.DateUtil;
import com.yao.springbootweixin.itchat4j.api.MessageTools;
import com.yao.springbootweixin.itchat4j.weixin.domain.FNewsDO;
import com.yao.springbootweixin.itchat4j.weixin.service.FNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-18 23:08
 **/
@JobHandler(value="newsNameHandle")
@Component
@Slf4j
public class NewsNameHandle extends IJobHandler {
    @Autowired
    FNewsService fNewsService;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        String dateStart = DateUtil.format(new Date());
        XxlJobLogger.log("---------------开始执行新闻程序["+dateStart+"]------------------");
        log.info("开始执行新闻程序["+dateStart+"]");
        FNewsDO fnews = fNewsService.getone();
        XxlJobLogger.log("获取结果-->"+fnews.toString());
        //核心业务模块
        boolean b = MessageTools.sendMsgByNickName(fnews.getNews(),s);
        if (b){
            XxlJobLogger.log("执行发送微信成功！");
            fnews.setDate(new Date());
            fnews.setFlag("1");
            int save = fNewsService.update(fnews);
            String a = save>0?"成功":"失败";
            XxlJobLogger.log("执行更新新闻！"+a);
        }else {
            XxlJobLogger.log("执行发送微信失败！");
        }

        String dateEnd = DateUtil.format(new Date());
        log.info("结束执行新闻程序["+dateEnd+"]");
        XxlJobLogger.log("---------------结束执行新闻程序["+dateEnd+"]------------------");
        return SUCCESS;
    }
}
