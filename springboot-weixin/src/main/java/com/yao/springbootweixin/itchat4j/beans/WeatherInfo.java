package com.yao.springbootweixin.itchat4j.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-09-17 21:38
 **/
@Getter
@Setter
@ToString
public class WeatherInfo {

    /**
     * date : 17日星期一
     * sunrise : 05:55
     * high : 高温 27.0℃
     * low : 低温 17.0℃
     * sunset : 18:22
     * aqi : 24.0
     * fx : 北风
     * fl : <3级
     * type : 多云
     * notice : 阴晴之间，谨防紫外线侵扰
     */

    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private String aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;

    public String getInfo(){
        StringBuffer sb = new StringBuffer();
        sb.append("小主早早早早上好,");
        sb.append("\r\n");
        sb.append("小主今天是"+date+",天气呢"+type+",");
        sb.append("\r\n");
        sb.append("气温是"+high+","+low+",");
        sb.append("\r\n");
        sb.append("风呢，风向"+fx+",风级别"+fl+",");
        sb.append("\r\n");
        sb.append("太阳出来的时间是"+sunrise+",太阳落山时间"+sunset+",");
        sb.append("\r\n");
        sb.append("小的建议"+notice+"！");
        return sb.toString();
    }
}
