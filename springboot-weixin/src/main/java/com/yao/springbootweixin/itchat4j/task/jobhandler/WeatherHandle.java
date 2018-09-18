package com.yao.springbootweixin.itchat4j.task.jobhandler;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-17 21:07
 **/

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.DateUtil;
import com.yao.springbootweixin.itchat4j.api.MessageTools;
import com.yao.springbootweixin.itchat4j.beans.WeatherInfo;
import com.yao.springbootweixin.itchat4j.service.weather.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 任务Handler示例（Bean模式）
 *
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2015-12-19 19:43:36
 */
@JobHandler(value="weatherHandle")
@Component
@Slf4j
public class WeatherHandle extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        String dateStart = DateUtil.format(new Date());
        XxlJobLogger.log("---------------开始执行天气预报程序["+dateStart+"]------------------");
        log.warn("开始执行天气预报程序["+dateStart+"]");
        String info = getWeatherString("合肥");
        XxlJobLogger.log("获取结果-->"+info);
        //核心业务模块
        boolean b = MessageTools.sendMsgByNickName(info,"娜");
        if (b){
            XxlJobLogger.log("执行发送微信成功！");
        }else {
            XxlJobLogger.log("执行发送微信失败！");
        }

        String dateEnd = DateUtil.format(new Date());
        log.warn("结束执行天气预报程序["+dateEnd+"]");
        XxlJobLogger.log("---------------结束执行天气预报程序["+dateEnd+"]------------------");
        return SUCCESS;
    }
    public static String getWeatherString(String city) throws Exception {
        List<WeatherInfo> weatherInfos = WeatherService.getjson(city);
        if (weatherInfos==null||weatherInfos.size()==0){
            return "抱歉小主，服务器异常。暂时无法获取天气。";
        }
//        for (int i=0;i<weatherInfos.size();i++){
//            WeatherInfo weatherInfo = new WeatherInfo();
//            weatherInfo = weatherInfos.get(i);
//            String info = weatherInfo.getInfo();
//        }

        WeatherInfo weatherInfo = weatherInfos.get(0);
        if (weatherInfo==null){
            return "抱歉小主，服务器异常。暂时无法获取天气。";
        }
        return weatherInfo.getInfo();

    }

    public static void main(String[] args) throws Exception {
        System.out.println(WeatherHandle.getWeatherString("合肥"));
    }
}
